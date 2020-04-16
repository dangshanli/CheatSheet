#include <iostream>

int main(int argc, char const *argv[])
{
    int sum = 0, val = 1;
    //从1加到10
    while (val <= 10)
    {
        sum += val;
        ++val;
    }

    std::cout << "sum of 1 to 10 inclusive is " << sum << std::endl;

    /**
     * 求出50加到100之间的数之和
     * */
    sum = 0;
    val = 50;

    while (val <= 100)
    {
        sum += val;
        ++val;
    }
    std::cout << "sum of 50 to 100 inclusive is " << sum << std::endl;

    /**
     * 逆序打印10->0之间的数字
     * */
    val = 10;
    while (val >= 0)
    {
        std::cout << "integer " << val << std::endl;
        --val;
    }

    /**
     * 控制台输入(标准输入)两个整数，求两个整数之间的和
     * 
     * */
    int low = 0, high = 0;
    sum = 0;
    std::cout << "请输入两个整数，前大，后小！！！" << std::endl;
    std::cin >> low >> high;
    if (low >= high)
    {
        return -1;
    }

    while (low <= high)
    {
        sum += low;
        ++low;
    }
    std::cout << "sum of " << low << " to " << high << " inclusive is " << sum << std::endl;

    /**
     * for loop
     * */

    sum = 0;
    for ( val = 0; val <= 10; val++)
    {
        sum += val;
    }
    std::cout << "use for loop: sum of 1 to 10 inclusive is " << sum << std::endl;
    
    /**
     * -100加到100
     * */
    sum = 0;
    for ( val = -100; val <= 100; val++)
    {
        sum += val;
    }
    std::cout << "use for loop: sum of -100 to 100 inclusive is " << sum << std::endl;
    return 0;
}
