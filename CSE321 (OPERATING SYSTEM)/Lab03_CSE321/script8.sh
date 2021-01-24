#!/bin/sh
f1() { var="123"; }
f2() { echo "12345"; }
f1
echo $var
result="$(f2)"
echo $result
