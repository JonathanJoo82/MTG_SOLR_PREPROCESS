#!/bin/bash
#
#Script for sending all parsed data of Magic the Gathering to AWS 3 bucket.
#
#

cd /mnt/c/Users/jonat/Project/Data/MTG_data/parsedJsonDataForSolr


for file in /mnt/c/Users/jonat/Project/Data/MTG_data/parsedJsonDataForSolr/. do
  if [ -f "$file" ]; then
    #move to a taring directory
    #take 1000 files and tar/delete these
    echo "hi"
  fi

done