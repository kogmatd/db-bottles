#!/bin/bash

DBHOME=$UASR_HOME-data/bottles
EXP=Versuch004_B

dlabpro $DBHOME/common/scripts/dlabpro/HMM_MIXEVAL.xtp $DBHOME/$EXP/info/$EXP.mcfg -Pam.model=0_0
dlabpro $DBHOME/common/scripts/dlabpro/HMM_MIXEVAL.xtp $DBHOME/$EXP/info/$EXP.mcfg -Pam.model=1_5
dlabpro $DBHOME/common/scripts/dlabpro/HMM_MIXEVAL.xtp $DBHOME/$EXP/info/$EXP.mcfg -Pam.model=2_7
dlabpro $DBHOME/common/scripts/dlabpro/HMM_MIXEVAL.xtp $DBHOME/$EXP/info/$EXP.mcfg -Pam.model=3_1
dlabpro $DBHOME/common/scripts/dlabpro/HMM_MIXEVAL.xtp $DBHOME/$EXP/info/$EXP.mcfg -Pam.model=4_0
