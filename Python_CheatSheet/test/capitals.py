def process_cities(filename):
    with open(filename, 'rt') as fin:
        for line in fin:
            line = line.strip()
            if 'quit' == line.lower():
                return
            country, city = line.split(',')
            city = city.strip()
            country = country.strip()
            print(city.title(), country.title(), sep='|')


if __name__ == '__main__':
    import sys
    process_cities(sys.argv[1])
    # process_cities('test/city2.csv')
