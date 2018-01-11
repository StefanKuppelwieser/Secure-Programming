int main (){
	
	int i;
	unsigned int j;
	
	i = 2147483647;
	i++;
	printf("i = %d\n", i);				// Ausgabe ohne GMP
										// i = -2147483648
										// Ausgabe mit GMP
										// i = 2147483648
	
	j = 429967295;
	j++;
	printf("j = %u\n", j);
										// Ausgabe ohne GMP
										// j = 0
										// Ausgabe mit GMP
										// j = 429967296
	i = -2147483647;
	i--;
	printf("i = %d\n", i);
										// Ausgabe ohne GMP
										// i = -2147483648
										// Ausgabe mit GMP
										// i = -2147483648
	j = 0;
	j = j--;
	printf("j = %u\n", j);
										// Ausgabe ohne GMP
										// j = 4294967295
										// Ausgabe mit GMP
										// j = 1
	i = -3;
	unsigned short u;
	u = i;
	printf("u = %hu\n", u);
										// Ausgabe ohne GMP
										// u = 65533  (unsigned short max = 65536 -> Abschnitt der höchsten 16 bit))
										// Ausgabe mit GMP
										// u = 65533 (unsigned short max = 65536 -> Abschnitt der höchsten 16 bit)
										
	unsigned short int us = 32768;
	short int is;
	is = us;
	printf("is = %d\n", is);
										// Ausgabe ohne GMP
										// ls = -32768
										// Ausgabe mit GMP
										// ls = -32768 
	
	us = 65535;
	is = us;
	printf("is = %d\n", is);
										// Ausgabe ohne GMP
										// ls = -1
										// Ausgabe mit GMP
										// ls = -1
}