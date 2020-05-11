
-- Insert Test (seed) Data
USE `mini-ebay-web`;

-- Insert into USER
INSERT INTO `USER` (Username, `Password`, First_name, Last_name) VALUES('user1', 'pass1', 'Danite', 'Kelor');
INSERT INTO `USER` (Username, `Password`, First_name, Last_name) VALUES('user2', 'pass2', 'Dodra', 'Kiney');
INSERT INTO `USER` (Username, `Password`, First_name, Last_name) VALUES('user3', 'pass3', 'Peran', 'Bishop');
INSERT INTO `USER` (Username, `Password`, First_name, Last_name) VALUES('user4', 'pass4', 'Randy', 'Roran');
INSERT INTO `USER` (Username, `Password`, First_name, Last_name) VALUES('user5', 'pass5', 'Ashod', 'lankel');
INSERT INTO `USER` (Username, `Password`, First_name, Last_name) VALUES('user6', 'pass6', 'Cany', 'Achant');
INSERT INTO `USER` (Username, `Password`, First_name, Last_name) VALUES('admin1', 'opensesame', 'Riley', 'Fuiss');
INSERT INTO `USER` (Username, `Password`, First_name, Last_name) VALUES('admin2', 'opensesayou', 'Tonnis', 'Kinser');

-- Insert into ADMIN_USER
INSERT INTO ADMIN_USER (Username, Position) VALUES('admin1', 'Technical Support');
INSERT INTO ADMIN_USER (Username, Position) VALUES('admin2', 'Chief Techy');

-- Insert into CATEGORY
INSERT INTO CATEGORY (Name) VALUES('Art');
INSERT INTO CATEGORY (Name) VALUES('Books');
INSERT INTO CATEGORY (Name) VALUES('Electronics');
INSERT INTO CATEGORY (Name) VALUES('Home & Garden');
INSERT INTO CATEGORY (Name) VALUES('Sporting Goods');
INSERT INTO CATEGORY (Name) VALUES('Toys');
INSERT INTO CATEGORY (Name) VALUES('Others');

-- Insert into ITEM
INSERT INTO ITEM (Item_ID, Owner_Username, Item_name, Description, Item_condition, Start_biding_price, Min_Sale_price, Get_it_now_price, Auction_ends_time, Returnable, Name)
VALUES(1, 'user1', 'Garmin GPS', 'This is a great GPS.', 3, 50.00, 70.00, 99.00, '2018/3/31 12:22', FALSE, 'Electronics');
INSERT INTO ITEM (Item_ID, Owner_Username, Item_name, Description, Item_condition, Start_biding_price, Min_Sale_price, Get_it_now_price, Auction_ends_time, Returnable, Name)
VALUES(2, 'user1', 'Canon Powershot', 'Point and shoot!', 2, 40.00, 60.00, 80.00, '2018/4/1 14:14', FALSE, 'Electronics');
INSERT INTO ITEM (Item_ID, Owner_Username, Item_name, Description, Item_condition, Start_biding_price, Min_Sale_price, Get_it_now_price, Auction_ends_time, Returnable, Name)
VALUES(3, 'user2', 'Nikon D3', 'New and in box!', 4, 1500.00, 1800.00, 2000.00, '2018/4/5 9:19', FALSE, 'Electronics');
INSERT INTO ITEM (Item_ID, Owner_Username, Item_name, Description, Item_condition, Start_biding_price, Min_Sale_price, Get_it_now_price, Auction_ends_time, Returnable, Name)
VALUES(4, 'user3', 'Danish Art Book', 'Delicious Danish Art', 3, 10.00, 10.00, 15.00, '2018/4/5 15:33', TRUE, 'Art');
INSERT INTO ITEM (Item_ID, Owner_Username, Item_name, Description, Item_condition, Start_biding_price, Min_Sale_price, Get_it_now_price, Auction_ends_time, Returnable, Name)
VALUES(5, 'admin1', 'SQL in 10 Minutes', 'Learn SQL really fast!', 1, 5.00, 10.00, 12.00, '2018/4/5 16:48', FALSE, 'Books');
INSERT INTO ITEM (Item_ID, Owner_Username, Item_name, Description, Item_condition, Start_biding_price, Min_Sale_price, Get_it_now_price, Auction_ends_time, Returnable, Name)
VALUES(6, 'admin2', 'SQL in 8 Minutes', 'Learn SQL even faster!', 2, 5.00, 8.00, 10.00, '2018/4/8 10:01', FALSE, 'Books');
INSERT INTO ITEM (Item_ID, Owner_Username, Item_name, Description, Item_condition, Start_biding_price, Min_Sale_price, Get_it_now_price, Auction_ends_time, Returnable, Name)
VALUES(7, 'user6', 'Pull-up Bar', 'Works on any door frame.', 4, 20.00, 25.00, 40.00, '2018/4/9 22:09', TRUE, 'Sporting Goods');
INSERT INTO ITEM (Item_ID, Owner_Username, Item_name, Description, Item_condition, Start_biding_price, Min_Sale_price, Get_it_now_price, Auction_ends_time, Returnable, Name)
VALUES(8, 'user6', 'Mac Book', 'Latest version!', 1, 2000.00, 3500.00, 4000.00, '2030/4/9 22:09', TRUE, 'Electronics');

-- Insert into BID
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user4', 1, '2018/3/30 14:53', 50.00, FALSE, FALSE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user5', 1, '2018/3/30 16:45', 55.00, FALSE, FALSE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user4', 1, '2018/3/30 19:28', 75.00, FALSE, FALSE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user5', 1, '2018/3/31 10:00', 85.00, FALSE, FALSE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user6', 2, '2018/4/1 13:55', 80.00, TRUE, TRUE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user1', 3, '2018/4/4 8:37', 1500.00, FALSE, FALSE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user3', 3, '2018/4/4 9:15', 1501.00, FALSE, FALSE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user1', 3, '2018/4/4 12:27', 1795.00, FALSE, FALSE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user4', 7, '2018/4/8 20:20', 20.00, FALSE, FALSE);
INSERT INTO BID (Username, Item_ID, Time_of_bid, Bid_amount, Is_get_it_now, Is_winner) VALUES('user2', 7, '2018/4/9 21:15', 25.00, FALSE, TRUE);

