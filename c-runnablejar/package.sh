#!/bin/bash

#
# Copyright (c) 2001-2016 Primeton Technologies, Ltd.
# All rights reserved.
#
# author: ZhongWen Li (mailto:lizw@primeton.com)
#

CONTEXT_PATH=$(cd $(dirname ${0}); pwd)

if [ -z "`which zip`" ]; then
	echo "[`date`] [ERROR] zip command not found."
	exit 1
fi

cd ${CONTEXT_PATH}/target
zip runnablejar-1.0.0-SNAPSHOT.zip *-jar-with-dependencies.jar