/*
 ============================================================================
 Name        : BDishionLoops.c
 Author      : Brendan Dishion
 Version     :
 Copyright   : Your copyright notice
 Description : Powers of 2 loop, do-while loop to get name from input
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	long int power;
	int number;
	char name[BUFSIZ + 1];
	double q;
	int ret;

	printf("\n======================================");
	printf("\n n     2 to power n     2 to power -n");
	printf("\n======================================");
	power = 1;
	for (number = 0; number < 11; ++number) {
		if (number == 0)
			power = 1;
		else
			power = power * 2;
		q = 1.0 / (double) power;
		printf("\n%2d    %8d    %20.12lf", number, power, q);
	}
	printf("\n======================================\n");

	do {
		printf("What is your name?");
		fgets(name, BUFSIZ, stdin);
		printf("%s", name);

		ret = strncmp(name, "\n", 1);

	} while (ret != 0);
	return 0;
}

