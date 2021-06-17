package com.binance.dex.api.client.examples;

import com.binance.dex.api.client.BinanceDexApiClientFactory;
import com.binance.dex.api.client.BinanceDexApiNodeClient;
import com.binance.dex.api.client.BinanceDexEnvironment;
import com.binance.dex.api.client.Wallet;
import com.binance.dex.api.client.domain.TransactionMetadata;
import com.binance.dex.api.client.domain.broadcast.SideVote;
import com.binance.dex.api.client.domain.broadcast.TransactionOption;

import java.io.IOException;
import java.util.List;

public class SideVoteExample {

    public static void main(String[] args) throws IOException {
        Wallet wallet = Wallet.createRandomWallet(BinanceDexEnvironment.TEST_NET);
        BinanceDexApiNodeClient binanceDexNodeApi = BinanceDexApiClientFactory.newInstance().newNodeRpcClient(BinanceDexEnvironment.TEST_NET.getNodeUrl(), null, BinanceDexEnvironment.TEST_NET.getHrp(), BinanceDexEnvironment.TEST_NET.getValHrp());


        TransactionOption options = TransactionOption.DEFAULT_INSTANCE;
        SideVote vote = new SideVote();
        vote.setOption(1);
        vote.setProposalId(2L);
        vote.setSideChainId("rialto");
        try {
            List<TransactionMetadata> resp = binanceDexNodeApi.sideVote(vote, wallet, options, true);
            System.out.println(resp.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
