#include <iostream>

/**
 * 不断的输入数值，统计连续出现相同数值的次数
 * */
int main(int argc, char const *argv[])
{
    int currVal = 0, val = 0;

    if (std::cin >> currVal)//首次输入
    {
        int cnt = 1;
        while (std::cin >> val)//循环输入
        {
            if (val == currVal)//相同+1
            {
                ++cnt;
            }
            else//出现新值则打印之前的统计量，并重新统计新值
            {
                std::cout << currVal << "出现了" << cnt << "次" << std::endl;
                currVal = val;
                cnt = 1;
            }
        }
        std::cout << currVal << "出现了" << cnt << "次" << std::endl;//结尾处打印最后一次的值的统计值
    }

    return 0;
}
