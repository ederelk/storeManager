#!/bin/sh
#
export DERBY_OPTS="-Dderby.system.home=databases"
./JavaDB/bin/startNetworkServer.sh
java -jar componentpack-enterprise.jar 