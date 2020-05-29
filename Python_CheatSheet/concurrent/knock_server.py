from twisted.internet import protocol, reactor,endpoints


class Knock(protocol.Protocol):
    def dataReceived(self, data):
        print('client: ', data)
        if data.startswith('Knock Knock'):
            response = 'who is there?'
        else:
            response = data + 'who?'
        print('server:', response)
        self.transport.write(response)


class KnockFactory(protocol.Factory):
    def buildProtocol(self, addr):
        return Knock()


endpoints.serverFromString(reactor,'tcp:8000').listen(KnockFactory())
reactor.run()
