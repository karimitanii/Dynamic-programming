# -*- coding: utf-8 -*-
"""
Created on Sun Apr 29 04:29:01 2024

@author: Karim Itani
"""
train_prices = [8, 6, 5, 800]
bus_prices = [8, 12, 5, 100]

n = len(train_prices) 
switch_cost = 10

dp = [0] * n
cost = 0
on_train = False  # boolean used for logic control flow

if train_prices[0] < bus_prices[0]:
    
    cost = train_prices[0]
    on_train = True

elif train_prices[0] > bus_prices[0]:

    cost = bus_prices[0]
    on_train = False


else:  # train_prices[0] == bus_prices[0]
    
    if train_prices[1]  > bus_prices[1]:
        cost = bus_prices[0]  # choose bus 
        on_train = False
    else:
        cost = train_prices[0]  # choose train 
        on_train = True

dp[0] = cost

for i in range(1, n):

    if on_train:
        if train_prices[i] > bus_prices[i] + switch_cost:

            cost += switch_cost + bus_prices[i]
            on_train = False
        else:

            cost += train_prices[i]
    else:

        if bus_prices[i] > train_prices[i] + switch_cost:

            cost += switch_cost + train_prices[i]
            on_train = True
        else:

            cost += bus_prices[i]

    dp[i] = cost

print(dp)
print("Suzie Q can reach her final destination by paying "+ str(dp[-1]) + " dollars")

