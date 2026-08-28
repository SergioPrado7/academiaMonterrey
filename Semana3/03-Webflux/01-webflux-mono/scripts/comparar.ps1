# comparar.ps1
# EL EXPERIMENTO DEL CURSO.
# Se le puede pasar el numero de peticiones, por defecto son 50.
# Ejemplo de uso: .\comparar.ps1 50

param (
    [int]$N = 50
)

$BASE = "http://localhost:8074"

# Intentamos leer la latencia directo del archivo Java
$Fuente = Join-Path $PSScriptRoot "..\src\main\java\com\academymty\webflux\mono\repo\EmployeeRepository.java"
if (Test-Path $Fuente) {
    $RegexMatch = Select-String -Path $Fuente -Pattern 'ofMillis\(([0-9]+)\)'
    $LatMs = $RegexMatch.Matches.Groups[1].Value
    $Lat = [math]::Round([double]$LatMs / 1000, 3)
} else {
    Write-Host "No pude encontrar el archivo Java, asumiendo 5 segundos." -ForegroundColor Yellow
    $Lat = 5
}

# Sacamos los nucleos del endpoint
$RespuestaHilo = curl.exe -s "$BASE/api/hilo" | ConvertFrom-Json
if (-not $RespuestaHilo) {
    Write-Host "No responde $BASE — ¿arrancaste la app?" -ForegroundColor Red
    exit
}
$Nucleos = $RespuestaHilo.hilosDisponibles

# Funcion para medir el tiempo de las N peticiones concurrentes
function Medir {
    param([string]$Ruta, [string]$Nombre)
    
    $Ini = [datetime]::UtcNow
    $Procesos = @()
    
    # Lanzamos las N peticiones a la vez (procesos ocultos para no ensuciar la pantalla)
    for ($i = 0; $i -lt $N; $i++) {
        $Procesos += Start-Process -FilePath "curl.exe" -ArgumentList "-s","-o","NUL","$BASE$Ruta" -PassThru -WindowStyle Hidden
    }
    
    # Esperamos a que terminen todas
    $Procesos | Wait-Process
    $Fin = [datetime]::UtcNow
    
    $Tiempo = ($Fin - $Ini).TotalSeconds
    Write-Host "  $($Nombre.PadRight(12)) $N peticiones en $($Tiempo.ToString('0.00')) s" -ForegroundColor Green
}

$EsperadoBloq = [math]::Round(($N / $Nucleos) * $Lat, 2)
$Tandas = [math]::Round($N / $Nucleos, 1)

Write-Host "`n  Tu maquina tiene $Nucleos nucleos, asi que el event loop de Netty tiene"
Write-Host "  ~$Nucleos hilos. Lanzamos $N peticiones CONCURRENTES a cada ruta.`n"

Write-Host "  Prediccion antes de correrlo:"
Write-Host "    reactivo    -> ~${Lat}s   (ningun hilo espera: las $N se solapan)"
Write-Host "    bloqueante  -> ~${EsperadoBloq}s   ($N peticiones / $Nucleos hilos = $Tandas tandas de ${Lat}s)`n"

Medir "/api/employees/1" "reactivo"
Medir "/api/mvc/employees/1" "bloqueante"

Write-Host "`n  La leccion NO es 'reactivo es rapido'. Las dos rutas tardan 5 s en el dato."
Write-Host "  La leccion es que el bloqueante DESPERDICIA los hilos que tiene, durmiendolos,"
Write-Host "  y por eso las peticiones hacen cola. El reactivo los suelta y no encola nada.`n"