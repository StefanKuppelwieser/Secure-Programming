// gmptest.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//

#include "stdafx.h"
#include "gmp.h"
#include <iostream>

int _tmain(int argc, _TCHAR* argv[])
{
	unsigned int j = 0;
	j = j - 1;

	mpz_t a, toSub;
	
	mpz_init(a);
	mpz_init_set_ui(a, 0);

	mpz_init(toSub);
	mpz_init_set_ui(toSub, 1);

	std::cout << "Initial value: " << mpz_get_ui(a) << std::endl;
	mpz_sub(a, a, toSub); 
	std::cout << "Value after subtraction: " << mpz_get_ui(a) << std::endl;
	
	std::cout << "\n\n";

	/* INTEGER */
	mpz_t res, toAdd;

	mpz_init(res);
	mpz_init_set_si(res, 2147483647); 

	mpz_init(toAdd);
	mpz_init_set_si(toAdd, 2147483648);

	std::cout << "max value: " << mpz_fits_slong_p << std::endl;

	std::cout << "Initial value: " << mpz_get_ui(res) << std::endl;
	mpz_add(res, res, toAdd); 
	std::cout << "Value after addition : " << mpz_get_ui(res) << std::endl;
	

	return 0;
}