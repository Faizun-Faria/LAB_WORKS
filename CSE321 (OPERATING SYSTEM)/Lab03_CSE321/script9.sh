#!/bin/sh
yes_or_no()
{
echo "Is your name $*?"
echo "Enter yes or no:"
read x
case "$x" in
y|yes) return 0;;
n|no) return 1;;
esac
}
if yes_or_no "$1"
then
echo "Hi $1, nice name"
else
echo "Never mind"
fi
