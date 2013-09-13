from SOAPpy import WSDL

'''
Created on 06/09/2013

@author: Nilseu Padilha	ragnarokkrr.blog@gmail.com
'''
# you'll need to configure these two values;
WSDLFILE = 'http://127.0.0.1:9876/ts?wsdl'

_server = WSDL.Proxy(WSDLFILE)

if __name__ == '__main__':
    import sys
    print "Time from Server: %s" % _server.getTimeAsString()
    print "Elapsed Time from Server???: %s" % _server.getTimeAsElapsed()
    