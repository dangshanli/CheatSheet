from twisted.internet import reactor, protocol


class KnockClient(protocol.Protocol):
    def connectionMade(self):
        self.transport.write('Knock knock')

    def dataReceived(self, data):
        if data.startswith('who is there?'):
            response = 'disappearing client'
            self.transport.write(response)
        else:
            self.transport.loseConnection()
            reactor.stop()

class KnockFactory(protocol.ClientFactory):
    protocol = KnockClient

def main():
    f = KnockFactory()
    reactor.connectTCP('localhost',8000,f)
    reactor.run()

if __name__ == '__main__':
    main()