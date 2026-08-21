#!/bin/bash
# Prueba end-to-end de todos los endpoints de CantanteRestController (MongoDB)
# Puerto 8081
BASE="http://localhost:8081/api/cantantes"

# Un ObjectId con formato valido que no existe en la coleccion
FANTASMA="000000000000000000000000"

paso() { echo; echo "════════ $1 ════════"; }
req()  { 
  local m=$1 u=$2 d=$3
  echo "→ curl -X $m $u ${d:+-H 'Content-Type: application/json' -d '$d'}"
  if [ -n "$d" ]; then
    curl -s -w "\n[HTTP %{http_code}]\n" -X "$m" "$u" -H "Content-Type: application/json" -d "$d"
  else
    curl -s -w "\n[HTTP %{http_code}]\n" -X "$m" "$u"
  fi
}

paso "1. GET todos (estado inicial)"
curl -s "$BASE" | jq .

paso "2. POST crear cantante"
NUEVO=$(curl -s -X POST "$BASE" -H "Content-Type: application/json" \
  -d '{"nombre":"Luis Miguel","nacionalidad":"Mexicana","popularidad":95,"ganancias":150.5,"albumMasVendido":"Romances"}')
echo "$NUEVO" | jq .
ID=$(echo "$NUEVO" | jq -r '.id')
echo "  ➜ ObjectId asignado: $ID"

paso "3. GET por id ($ID)"
req GET "$BASE/$ID"

paso "4. PUT actualización completa"
req PUT "$BASE" "{\"id\":\"$ID\",\"nombre\":\"Luis Miguel\",\"nacionalidad\":\"Mexicana\",\"popularidad\":98,\"ganancias\":180.0,\"albumMasVendido\":\"Romance\"}"

paso "5. PATCH actualización parcial (solo ganancias)"
req PATCH "$BASE/$ID" '{"ganancias":200.0}'

paso "6. PATCH con id en el body (debe fallar: 500 por seguridad)"
req PATCH "$BASE/$ID" '{"id":"999","popularidad":100}'

paso "7. GET de un ObjectId inexistente (debe fallar: 500 id not found)"
req GET "$BASE/$FANTASMA"

paso "8. DELETE id $ID"
req DELETE "$BASE/$ID"

paso "9. GET del id borrado (debe fallar: 500 id not found)"
req GET "$BASE/$ID"

paso "10. GET todos (estado final: igual al inicial)"
curl -s "$BASE" | jq .

#-------------------------------------------------------------------------------------------#

# Estos son para Windows PowerShell
# Si estas en Windows, copia los comandos de abajo y pegalos en tu consola de PowerShell

# $BASE = "http://localhost:8081/api/cantantes"
# $FANTASMA = "000000000000000000000000"
# 
# function paso([string]$mensaje) {
#     Write-Host "`n════════ $mensaje ════════" -ForegroundColor Cyan
# }
# 
# paso "1. GET todos (estado inicial)"
# Invoke-RestMethod -Method GET -Uri $BASE | ConvertTo-Json
# 
# paso "2. POST crear cantante"
# $bodyPost = @{
#     nombre = "Luis Miguel"
#     nacionalidad = "Mexicana"
#     popularidad = 95
#     ganancias = 150.5
#     albumMasVendido = "Romances"
# } | ConvertTo-Json
# $nuevo = Invoke-RestMethod -Method POST -Uri $BASE -Body $bodyPost -ContentType "application/json"
# $nuevo | ConvertTo-Json
# $ID = $nuevo.id
# Write-Host "  ➜ ObjectId asignado: $ID" -ForegroundColor Green
# 
# paso "3. GET por id ($ID)"
# Invoke-RestMethod -Method GET -Uri "$BASE/$ID" | ConvertTo-Json
# 
# paso "4. PUT actualización completa"
# $bodyPut = @{
#     id = $ID
#     nombre = "Luis Miguel"
#     nacionalidad = "Mexicana"
#     popularidad = 98
#     ganancias = 180.0
#     albumMasVendido = "Romance"
# } | ConvertTo-Json
# Invoke-RestMethod -Method PUT -Uri $BASE -Body $bodyPut -ContentType "application/json" | ConvertTo-Json
# 
# paso "5. PATCH actualización parcial (solo ganancias)"
# $bodyPatch = @{ ganancias = 200.0 } | ConvertTo-Json
# Invoke-RestMethod -Method PATCH -Uri "$BASE/$ID" -Body $bodyPatch -ContentType "application/json" | ConvertTo-Json
# 
# paso "6. PATCH con id en el body (debe fallar: 500 por seguridad)"
# try {
#     $bodyPatch2 = @{ id = "999"; popularidad = 100 } | ConvertTo-Json
#     Invoke-RestMethod -Method PATCH -Uri "$BASE/$ID" -Body $bodyPatch2 -ContentType "application/json" | ConvertTo-Json
# } catch { Write-Host "Error esperado capturado: $_" -ForegroundColor Yellow }
# 
# paso "7. GET de un ObjectId inexistente (debe fallar: 500 id not found)"
# try { Invoke-RestMethod -Method GET -Uri "$BASE/$FANTASMA" } catch { Write-Host "Error esperado capturado: $_" -ForegroundColor Yellow }
# 
# paso "8. DELETE id $ID"
# Invoke-RestMethod -Method DELETE -Uri "$BASE/$ID"
# Write-Host "Eliminado correctamente."
# 
# paso "9. GET del id borrado (debe fallar: 500 id not found)"
# try { Invoke-RestMethod -Method GET -Uri "$BASE/$ID" } catch { Write-Host "Error esperado capturado: $_" -ForegroundColor Yellow }
# 
# paso "10. GET todos (estado final: igual al inicial)"
# Invoke-RestMethod -Method GET -Uri $BASE | ConvertTo-Json

