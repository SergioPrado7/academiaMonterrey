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