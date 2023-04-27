from spyne import Application, rpc, ServiceBase, Iterable, Integer, Unicode
from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication
from datetime import datetime

soapPort = 8880

class CurrencyService(ServiceBase):
    @rpc(Unicode, _returns = float)
    def getCurrency(ctx, currencyName,):
        # getting some currency
        rate = 1.2
        return rate

application = Application([CurrencyService], 'dude', in_protocol=Soap11(validator='lxml'), out_protocol=Soap11())                       
wsgi_application = WsgiApplication(application)

if __name__ == '__main__':
    import logging
    from wsgiref.simple_server import make_server

    print(f"Creating server on port {soapPort}")
    server = make_server('0.0.0.0', soapPort, wsgi_application)
    server.serve_forever()