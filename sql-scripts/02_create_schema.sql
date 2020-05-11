DROP DATABASE IF EXISTS `mini-ebay-web`;
SET default_storage_engine=InnoDB;
SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE DATABASE IF NOT EXISTS `mini-ebay-web`
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;
USE `mini-ebay-web`;

-- Tables

CREATE TABLE `USER` (
  Username varchar(60) NOT NULL,
  Password varchar(60) NOT NULL,
  First_name varchar(100) NOT NULL,
  Last_name varchar(100) NOT NULL,
  PRIMARY KEY (Username)
);

CREATE TABLE ADMIN_USER (
  Username varchar(60) NOT NULL,
  Position varchar(250) NOT NULL,
  PRIMARY KEY (Username)
);

CREATE TABLE CATEGORY (
  Name varchar(60) NOT NULL,
  PRIMARY KEY (Name)
);

CREATE TABLE ITEM (
  Item_ID int(16) unsigned NOT NULL AUTO_INCREMENT,
  Owner_Username varchar(60) NOT NULL,
  Item_name varchar(250) NOT NULL,
  Description varchar(1000) DEFAULT '',
  Item_condition int(8) unsigned NOT NULL CHECK (Item_condition BETWEEN 1 AND 5),
  Start_biding_price decimal(14, 2) NOT NULL DEFAULT 0,
  Min_sale_price decimal(14, 2) NOT NULL DEFAULT 0,
  Get_it_now_price decimal(14, 2) DEFAULT NULL,
  Auction_ends_time datetime NOT NULL,
  Returnable BIT NOT NULL DEFAULT 1,
  Name varchar(60) NOT NULL,
  PRIMARY KEY (Item_ID)
 );

CREATE TABLE BID (
  Username varchar(60) NOT NULL,
  Item_ID int(16) unsigned NOT NULL,
  Time_of_bid datetime NOT NULL,
  Bid_amount decimal(14, 2) NOT NULL CHECK (Bid_amount > 0),
  Is_get_it_now BIT NOT NULL DEFAULT 0,
  Is_winner BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (Username, Item_ID, Time_of_bid)
);

-- Constraints   Foreign Keys: FK_ChildTable_childColumn_ParentTable_parentColumn AND other general constraints

ALTER TABLE ADMIN_USER
  ADD CONSTRAINT fk_ADMIN_USER_Username_USER_Username FOREIGN KEY (Username) REFERENCES `USER` (Username);

ALTER TABLE ITEM
  ADD CONSTRAINT fk_ITEM_Owner_Username_USER_Username FOREIGN KEY (Owner_Username) REFERENCES `USER` (Username),
  ADD CONSTRAINT fk_ITEM_Name_CATEGORY_Name FOREIGN KEY (Name) REFERENCES CATEGORY (Name),
  ADD CONSTRAINT item_price_constraint1 CHECK (Min_sale_price >= Start_biding_price),
  ADD CONSTRAINT item_price_constraint2 CHECK (Min_sale_price <= Get_it_now_price);
  -- ADD CONSTRAINT item_price_constraint3 CHECK (Sale_price >= Min_sale_price);

ALTER TABLE BID
  ADD CONSTRAINT fk_BID_Username_User_Username FOREIGN KEY (Username) REFERENCES `USER` (Username),
  ADD CONSTRAINT fk_BID_Item_ID_ITEM_Item_ID FOREIGN KEY (Item_ID) REFERENCES ITEM (Item_ID);

