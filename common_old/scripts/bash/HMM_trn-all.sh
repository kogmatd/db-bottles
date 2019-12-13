#!/bin/bash

DBHOME=$UASR_HOME-data/bottles

cd $DBHOME/Versuch004_A;    nohup HMM.xtp trn info/Versuch004_A.mcfg    2>&1 &
cd $DBHOME/Versuch004_B;    nohup HMM.xtp trn info/Versuch004_B.mcfg    2>&1 &
cd $DBHOME/Versuch004_C;    nohup HMM.xtp trn info/Versuch004_C.mcfg    2>&1 &
#cd $DBHOME/Vorversuch001_A; nohup HMM.xtp trn info/Vorversuch001_A.mcfg 2>&1 &
#cd $DBHOME/Vorversuch001_B; nohup HMM.xtp trn info/Vorversuch001_B.mcfg 2>&1 &
#cd $DBHOME/Vorversuch001_C; nohup HMM.xtp trn info/Vorversuch001_C.mcfg 2>&1 &
#cd $DBHOME/Vorversuch002_A; nohup HMM.xtp trn info/Vorversuch002_A.mcfg 2>&1 &
#cd $DBHOME/Vorversuch002_B; nohup HMM.xtp trn info/Vorversuch002_B.mcfg 2>&1 &
#cd $DBHOME/Vorversuch002_C; nohup HMM.xtp trn info/Vorversuch002_C.mcfg 2>&1 &
#cd $DBHOME/Vorversuch003_A; nohup HMM.xtp trn info/Vorversuch003_A.mcfg 2>&1 &
#cd $DBHOME/Vorversuch003_B; nohup HMM.xtp trn info/Vorversuch003_B.mcfg 2>&1 &
#cd $DBHOME/Vorversuch003_C; nohup HMM.xtp trn info/Vorversuch003_C.mcfg 2>&1 &
