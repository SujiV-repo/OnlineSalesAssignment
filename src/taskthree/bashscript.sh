#!/bin/bash
N=$1
if [ $N -lt 10 ]
then
        OUT=$((N*N))
elif [ $N -lt 20 ]
then
        OUT=1
        LIM=$((N - 10))
        for (( i=1; i<$LIM; i++ ))
        do
                OUT=$((OUT * i))
        done
else
        LIM=$((N - 20))
        #This is the change that needs to be done to get sum of 1 to N-20
        (( OUT = LIM * (LIM+1) /2))

fi
echo $OUT