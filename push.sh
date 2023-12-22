#!/usr/bin/env bash
echo "更新日志: $1"
git add .
git commit -a -m "$1"
git push origin main