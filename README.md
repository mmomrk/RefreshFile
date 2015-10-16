# RefreshFile

Code for database refreshing.

Presumed conditions: base runs in some program. You have to switch the base with a new version.

Code downloads base from the link. Checks if it is different from existing. If yes-it kills program that uses base, makes a backup, replaces the base with a new one, starts the program again. Everything is hardcoded since nobody is interested in this solution

Code compiled by me, feel free to use it 
