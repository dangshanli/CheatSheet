#include <iostream>

int main(int argc, char const *argv[])
{
    std::cout << "read each file." << std::endl;
    std::cout << "update master." << std::endl;
    std::cout << "write master." << std::endl;
    std::cout << "write new master." << std::endl;

    std::string a;
    a = "loverlace";
    std::cout << a << std::endl;

    int v1 = 0, v2 = 0;
    std::cin >> v1 >> v2;
    std::cout << v1 + v2 << std::endl;
    // std::in >> v1;
    std::cin >> v1;

    return 0;
}
