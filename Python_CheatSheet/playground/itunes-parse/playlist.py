import argparse
import plistlib


def findDuplicates(filename: str):
    '''解析plist xml文件，输出{name:(duration,count)}字典'''
    print('在文件{}中搜索备份tracks'.format(filename))
    with open(filename, 'rb') as fp:
        plist = plistlib.load(fp)  # 加载文件
    tracks = plist['Tracks']
    trackNames = {}  # name:(duration,count)
    for trackId, track in tracks.items():
        try:
            name = track['Name']
            duration = track['Total Time']
            if name in trackNames:  # name已存在且时常一样，则count+1
                if duration//1000 == trackNames[name][0]//1000:
                    count = trackNames[name][1]
                    trackNames[name] = (duration, count+1)
            else:
                trackNames[name] = (duration, 1)
        except:
            pass
    _dumpTrack(trackNames)


def _dumpTrack(tracks: dict):
    '''将出现次数大于1的歌曲，写入本地文件'''
    dups = []
    for k, v in tracks.items():
        if v[1] > 1:
            dups.append((k, v[1]))
    if len(dups) > 0:
        print(
            'found {:d} duplicates.track names saved to resources/dups.txt'.format(len(dups)))
    else:
        print('no duplicate track found!')
    fout = open('../../resources/dups.txt', 'wt')
    for val in dups:
        fout.write('{:s} [{:d}]\n'.format(val[0], val[1]))
    fout.close()


def findCommonTracks(fileNames: list):
    '''多个xml文件中寻找歌名交集'''
    trackNameSets = []
    # 解析xml文件，将Name属性写入set,并求出交集
    for filename in fileNames:
        trackNames = set()
        with open(filename, 'rb') as fb:
            plist = plistlib.load(fb)
        tracks = plist['Tracks']
        for trackId, track in tracks.items():
            try:
                trackNames.add(track['Name'])
            except:
                pass
        trackNameSets.append(trackNames)
    commonTracks = set.intersection(*trackNameSets)

    # 将交集曲目写入本地文件
    if len(commonTracks) > 0:
        with open('../../resources/common.txt', 'wb') as fout:
            for val in commonTracks:
                fout.write('{}\n'.format(val).encode('utf-8'))
        print('{:d} tracks found! track name writen into resources/common.txt'.format(len(commonTracks)))
    else:
        print('no common tracks')


def plotStats(fileName: str):
    from matplotlib import pyplot
    import numpy as np
    '''搜集plist信息 Album-Rating & Total-Time'''
    with open(fileName, 'rb') as fin:
        plist = plistlib.load(fin)
    tracks = plist['Tracks']
    rating = []
    duration = []
    for trackId, track in tracks.items():
        try:
            rating.append(track['Album Rating'])
            duration.append(track['Total Time'])
        except:
            pass

    if rating == [] or duration == []:
        print('no valid album rating/total time data in {:s}'.format(fileName))
        return

    x = np.array(duration, np.int32)
    y = np.array(rating, np.int32)
    x = x/(60 * 1000.0)  # 转化成分钟
    pyplot.subplot(2, 1, 1)
    pyplot.plot(x, y, 'o')
    pyplot.axis([0, 1.05*max(x), -1, 110])
    pyplot.xlabel('Track duretion')
    pyplot.ylabel('Track rating')

    pyplot.subplot(2, 1, 2)
    pyplot.hist(x, bins=20)
    pyplot.xlabel('Track duration')
    pyplot.ylabel('Count')

    pyplot.show()


def main():
    descStr = '''
    this program analyzes playlist files (.xml) exported from iTunes'''
    parser = argparse.ArgumentParser(description=descStr)#argparse用于命令行输入参数
    group = parser.add_mutually_exclusive_group()  # 互斥组
    group.add_argument('--common', nargs='*', dest='plFiles', required=False)
    group.add_argument('--stats', dest='plFile', required=False)
    group.add_argument('--dup', dest='plFileD', required=False)

    args = parser.parse_args()

    if args.plFiles:
        findCommonTracks(args.plFiles)
    elif args.plFile:
        plotStats(args.plFile)
    elif args.plFileD:
        findDuplicates(args.plFileD)
    else:
        print('wrong command,please use --commo or --stats or --dup ')


path = 'D:\\Py_Projects\\pp\\playlist\\test-data\\mymusic.xml'
# findDuplicates(path)
p1 = 'D:\\Py_Projects\\pp\\playlist\\test-data\\pl1.xml'
p2 = 'D:\\Py_Projects\\pp\\playlist\\test-data\\pl2.xml'
p3 = 'D:\\Py_Projects\\pp\\playlist\\test-data\\rating.xml'
# findCommonTracks([p1, p2])
# plotStats(p3)

if __name__ == '__main__':
    main()
