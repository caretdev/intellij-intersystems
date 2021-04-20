#!/bin/bash

VERSION=0.1.0-beta.3
TARGET=lib/language-server

curl -sL https://github.com/caretdev/intersystems-ls/releases/download/v$VERSION/intersystems-ls.tgz \
  | tar -xz -C $TARGET

find $TARGET/* -type file -exec chmod +x {} \;