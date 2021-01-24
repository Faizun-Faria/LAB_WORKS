#!/bin/bash
showarg()
{
a=1
for i in $*
do 
echo "The $a No arg is $i"
a=`expr $a + 1`
done
}
echo "Listing start"
showarg $*
echo "Total:$#"
echo "Listing End"
