// Uebung03.cpp : Definiert den Einstiegspunkt für die Konsolenanwendung.
//


#include "stdafx.h"
#include "curl\curl.h"
#include <string>
#include <iostream>
#include <regex>

	//define variables
	std::string data;


size_t writeCallback(char* buf, size_t size, size_t nmemb, void* up){

	for (size_t c = 0; c < (size*nmemb); c++)
	{
		data.push_back(buf[c]);
	}
	
	return size * nmemb;
}

int main(int argc, _TCHAR* argv[])
{

	do
	{
		std::string input;
		std::regex reg ("^(ftp|http|https|file):\\/\\/[[:alnum:]]+.[a-zA-Z]+");

		std::cin >> data;
		std::cout << data << " is: " << std::regex_match(data, reg);
	}while(true);


	/**

	do
	{
		std::cout << "-------------------------------------------------------" << std::endl;
		std::cout << "Dieses Tool, soll eine Datei von einem Link downloaden!" << std::endl;
		std::cout << "Bitte geben Sie einen Link zur datei an:" << std::endl;
		//std::cin >> path;




		CURL *curl;
		
		curl_global_init(CURL_GLOBAL_ALL);
		curl = curl_easy_init();

		curl_easy_setopt(curl, CURLOPT_URL, "http://www.google.com");
		curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, &writeCallback);
		curl_easy_setopt(curl, CURLOPT_VERBOSE, 1L);

		curl_easy_cleanup(curl);

		std::cout << std::endl << data << std::endl;
		std::cin >> data ;
		

		curl_easy_cleanup(curl);
		curl_global_cleanup();

	}while(true);

	**/

	return 0;
}