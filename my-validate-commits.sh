#!/bin/bash

# Define the branch names
feature_branch=feat/lint-pr
main_branch=main

# Get all commit messages from the feature branch that are not in the main branch
commits=($(git log --pretty="%s EON" $feature_branch ^$main_branch))

pattern="(feat|fix|ci|chore|docs|test|style|refactor): +#([0-9]+) -.{1,}$"

# Loop through the array and create other structure data
commits_struct=()
for commit in "${commits[@]}"; do
  # Split the commit message into hash and message
  if [ $commit != "EON" ]; then
    commit_msg+=" $commit"
  fi
  if [ $commit == "EON" ]; then
    commits_struct+=("${commit_msg}")
    commit_msg=""
  fi
done

all_commits_ok=true
for msg in "${commits_struct[@]}"; do
  if [[ $msg =~ $pattern ]]; then
    echo "this commit: ${msg} is correct"
  else
    echo "this commit: ${msg} is wrong"
    all_commits_ok=false
  fi
done

if [ all_commits_ok==false ]; then
   exit 1
fi
