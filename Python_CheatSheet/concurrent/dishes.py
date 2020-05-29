import multiprocessing as mp

'''多进程处理任务'''


def washer(dishes, output):
    for dish in dishes:
        print('washing ', dish, ' dish')
        output.put(dish)


def dryer(input):
    while(True):
        dish = input.get()
        print('drying ', dish, ' dish')
        input.task_done()


if __name__ == '__main__':
    dishes = ['salad', 'bread', 'entree', 'dessert']
    dish_queue = mp.JoinableQueue()
    washer(dishes, dish_queue)  # 主进程洗盘子，输出到缓存队列，等待进一步处理

    dryer_proc = mp.Process(target=dryer, args=(
        dish_queue,))  # 子进程擦干盘子，他的输入来自于JoinableQueue
    dryer_proc.daemon = True
    dryer_proc.start()

    dish_queue.join()
