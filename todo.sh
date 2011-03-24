#!/bin/bash

# Automatically generates a to-do list at the end of README

lines=$(grep -n '^To-do$' README | cut -f 1 -d ':')
if [[ $lines!=0 ]]; then
  #head -n $(grep -n '^To-do$' README | cut -f 1 -d ':') README >> new_README
  head -n $(($lines-1)) README >> new_README
fi
echo 'To-do' >> new_README
echo '-----' >> new_README
echo -e $(cat *.java | grep TODO) | sed 's/\/\//\n/g' | sed 's/;$//' >> new_README
echo "" >> new_README
echo "(don't write anything past this point)" >> new_README
mv new_README README
