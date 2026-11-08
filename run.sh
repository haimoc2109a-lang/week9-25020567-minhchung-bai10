#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "${BASH_SOURCE[0]}")"
if ! command -v mvn >/dev/null 2>&1; then
  echo "Cần cài Maven và JDK 25 để chạy bài này." >&2
  exit 1
fi
mvn -B clean verify
