DIR=weibo
JM=java -cp .:../Praprolog/bin/:../Praprolog/lib/*:../Praprolog/conf/ edu.cmu.ml.praprolog
PSTEM=weibo1
P=$(PSTEM).crules
SRW1=l2p:0.0012:10
WT=tanh
EPOCHS=10
TH=32

#PR=dpr:0.001:0.1:adjust
PR=ppr:5

##############################################################################

data:
	../scripts/conll2proppr_weibo.pl ww_dataset_conll_tagged; \
       cp ww_dataset_conll_tagged.data all.data; \
	cp ww_dataset_conll_tagged.facts all.facts; \

	head -1020 all.data > testA.data; \
	head -2021 all.data | tail -1001 > testB.data; \
	tail -2185 all.data > train.data; \

%.run: 
	cd ../Praprolog/; ./scripts/compile.sh ../weibo/;cd ../weibo; \
	$(JM).Experiment --programFiles $(P):all.cfacts --prover $(PR) --epochs $(EPOCHS) \
			 --strict --train train.data --test $*.data --srw $(SRW1) --output train.grounded \
			 --params train.params --traceLosses --threads $(TH) --weightingScheme $(WT) --queryAnswerer qa:unnorm \
			 --solutions $*.answers --queries $*.data --notest; \

	../scripts/scoring.pl $*.answers $*.data > $*.results; \
	cat $*.results; \

%.query:
	$(JM).QueryAnswerer --programFiles $(P):all.cfacts --prover $(PR) \
			 --strict--test $*.data --srw $(SRW1) --output train.grounded \
			 --params train.params --traceLosses --threads $(TH) --weightingScheme $(WT) --queries $*.data; \
	../scripts/scoring.pl $*.answers $*.data > $*.results; \
	cat $*.results; \





