package belvedereTradingOA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class oa3 {
    private static DecimalFormat Formatter = new DecimalFormat("0.00");

    public static class MarketDataLevel{
        public double Price;
        public int Quantity;

        public MarketDataLevel(double price, int qty){
            Price = price;
            Quantity = qty;
        }
    }

    public static class TradeRequest {
        public int Quantity;
        public double RiskPerQty;

        public TradeRequest(int qty, double riskPerQty) {
            Quantity = qty;
            RiskPerQty = riskPerQty;
        }
    }

    public static double remain_risk = 0;

    public static void main(String[] args) throws IOException{
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        ArrayList<MarketDataLevel> buy_market = new ArrayList<MarketDataLevel>();
        ArrayList<MarketDataLevel> sell_market = new ArrayList<MarketDataLevel>();
        int lineNum = 0;
        while((line = in.readLine()) != null) {
            if(line == "e"){
                break;
            }
            String[] lines = line.split(" ");
            if(lineNum == 0){
                buy_market = parseMarketData(lines);
            }else if(lineNum == 1){
                sell_market = parseMarketData(lines);
            }else{
                TradeRequest tr = parseTradeRequest(lines);
                calculateHedge(buy_market, sell_market, tr);
            }
            lineNum++;
        }
    }

    private static ArrayList<MarketDataLevel> parseMarketData(String[] lines){
        ArrayList<MarketDataLevel> marketData = new ArrayList<MarketDataLevel>();
        for(int i = 0; i < lines.length - 1; i += 2){
            double price = Double.parseDouble(lines[i + 1]);
            int qty = Integer.parseInt(lines[i]);
            MarketDataLevel md = new MarketDataLevel(price, qty);
            marketData.add(md);
        }
        return marketData;
    }

    private static TradeRequest parseTradeRequest(String[] lines){
        int qty = 0;
        double risk = 0;
        for(int i = 0; i < lines.length - 1; i += 2){
            qty = Integer.parseInt(lines[i]);
            risk = Double.parseDouble(lines[i + 1]);
        }
        return new TradeRequest(qty, risk);
    }

    private static void calculateHedge(ArrayList<MarketDataLevel> buy_market, ArrayList<MarketDataLevel> sell_market, TradeRequest req){
        int hedgeQuantity = 0;
        double hedgePrice = 0;
        //
        int qty = req.Quantity;
        double riskPerQty = req.RiskPerQty;
        double totalRisk = qty * riskPerQty + remain_risk;
        int balanceUnit = (int)(-totalRisk);
        remain_risk = totalRisk + (double)balanceUnit;
        // sell risk
        if(balanceUnit < 0){
            hedgeQuantity = balanceUnit;
            balanceUnit = -balanceUnit;
            double totalPrice = 0;
            for(int i = 0; i < sell_market.size(); i++){
                double cur_price = sell_market.get(i).Price;
                int cur_quan = sell_market.get(i).Quantity;
                if(cur_quan >= balanceUnit){
                    // update the market data
                    sell_market.get(i).Quantity = cur_quan - balanceUnit;
                    // update current cost
                    totalPrice += (double)balanceUnit * cur_price;
                    // update left need
                    balanceUnit = 0;
                }else{
                    sell_market.get(i).Quantity = 0;
                    totalPrice += (double)cur_quan * cur_price;
                    balanceUnit -= cur_quan;
                }
                if(balanceUnit == 0){
                    break;
                }
            }
            hedgePrice = -totalPrice / (double)hedgeQuantity;
        }
        // buy risk
        if(totalRisk <= 0){
            hedgeQuantity = balanceUnit;
            double totalPrice = 0;
            for(int i = 0; i < buy_market.size(); i++){
                double cur_price = buy_market.get(i).Price;
                int cur_quan = buy_market.get(i).Quantity;
                if(cur_quan >= balanceUnit){
                    buy_market.get(i).Quantity = cur_quan - balanceUnit;
                    totalPrice += (double)balanceUnit * cur_price;
                    balanceUnit = 0;
                }else{
                    buy_market.get(i).Quantity = 0;
                    totalPrice += (double)cur_quan * cur_price;
                    balanceUnit -= cur_quan;
                }
                if(balanceUnit == 0){
                    break;
                }
            }
            hedgePrice = totalPrice / hedgeQuantity;
        }
        System.out.println(hedgeQuantity + " " + Formatter.format(hedgePrice));
    }

}
