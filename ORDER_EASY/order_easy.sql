-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2018 at 05:28 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `order_easy`
--

-- --------------------------------------------------------

--
-- Table structure for table `food_items`
--

CREATE TABLE `food_items` (
  `id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `image` varchar(200) NOT NULL,
  `price` float NOT NULL,
  `category` tinyint(2) NOT NULL,
  `description` varchar(255) NOT NULL,
  `quantity_type` int(10) NOT NULL,
  `item_type` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food_items`
--

INSERT INTO `food_items` (`id`, `name`, `image`, `price`, `category`, `description`, `quantity_type`, `item_type`) VALUES
(1, 'Kakori Kebabs', 'ic_lasoonipaneertikka.jpg', 150, 0, 'Paneer Grilled with Mozerella Cheese', 1, 1),
(3, 'Stir Fried Chilli Chicken', 'ic_murghharimirchtikka.jpg', 300, 1, 'Delicious Chicken with spicy gravy', 1, 1),
(4, 'Chicken Satay', 'ic_murghseekhkebab.jpg', 350, 1, 'Chicken Dish', 1, 1),
(5, 'Tamatar Dhania Shorba', 'ic_tamatardhaniashorba.jpg', 169, 0, 'Mildly Spiced Tomato and Coriander Soup', 1, 1),
(6, 'Palak Shorba', 'ic_palakshorba.jpg', 169, 0, 'Pureed Spinach Soup FlavouRed with Spices ', 1, 1),
(7, 'Murgh Yakhni Shorba', 'ic_murghyakhnishorba.jpg', 189, 1, 'Aromatic Chicken Soup Mildly Spiced', 1, 1),
(8, 'Paya Shorba', 'ic_payashorba.jpg', 209, 1, 'Classic Lamb Trotter Soup', 1, 1),
(9, 'Tandoori Chatpate Aloo Cheese Roll', 'ic_tandoorichatpatealoocheeseroll.jpg', 159, 0, 'Roll Stuffed with Potato', 1, 1),
(10, 'Tandoori Paneer Tikka Roll', 'ic_tandooripaneertikkaroll.jpg', 179, 0, 'Roll Stuffed with Grilled Paneer', 1, 1),
(11, 'Paneer Hari Mirch Tikka Roll', 'ic_paneerharimirchtikka.jpg', 179, 0, 'Roll Stuffed with Green Chilli and Grilled Paneer', 1, 1),
(12, 'Paneer Peeli Mirch Tikka Roll', 'ic_paneerpeelimirchtikkaroll.jpg', 179, 0, 'Roll Stuffed with Red Chilli and Grilled Paneer', 1, 1),
(13, 'Lasooni Paneer Tikka Roll', 'ic_lasoonipaneertikkaroll.jpg', 179, 0, 'Roll Stuffed with Garlic Mash and Paneer', 1, 1),
(14, 'Murgh Malai Tikka Roll', 'ic_murghmalaitikka.jpg', 199, 1, 'Cheese and Chicken Filled Roll', 1, 1),
(15, 'Murgh Tikka Roll', 'ic_murghtikkaroll.jpg', 199, 1, 'Grilled Chicken Stuffed Roll', 1, 1),
(16, 'Murgh Kalimiri Tikka Roll', 'ic_murghkalimiritikka.jpg', 199, 1, 'Grilled Chicken with Kalimari Sauce Stuffed Roll', 1, 1),
(17, 'Murgh Peeli Mirch Tikka Roll', 'ic_murghpeelimirchtikka.jpg', 199, 1, 'Grilled Chicken with Red Chilli Stuffed Roll', 1, 1),
(18, 'Murgh Hari Mirch Tikka Roll', 'ic_murghharimirchtikkaroll.jpg', 199, 1, 'Grilled Chicken with a slight Green Chilli taste stuffed in a roll', 1, 1),
(19, 'Murgh Seekh Kebab Roll', 'ic_murghseekhkebab.jpg', 199, 1, 'Seekh Kebab Stuffed in a Roll', 1, 1),
(20, 'Gosht Seekh Kebab Roll', 'ic_goshtseekhkebab.jpg', 219, 1, 'Gosht Kebab Stuffed Roll', 1, 1),
(21, 'Tandoori Chatpate Aloo', 'ic_tandoorichatpatealoo.jpg', 229, 0, 'Baby Potatoes in a Tangy marinade and Grilled', 1, 1),
(22, 'Brocooli Tandoori', 'ic_broccolitandoori.jpg', 259, 0, 'Brocolli Marinade in Red Masala and Grilled', 1, 1),
(23, 'Butter Garlic Mushroom', 'ic_buttergarlicmushroom.jpg', 259, 0, 'Button Mushroom Grilled with Garlic marinade and butter', 1, 1),
(24, 'Mushroom Tikka', 'ic_mushroomtikka.jpg', 259, 0, 'Button Mushroom in a spiced Yoghurt Marinade and Grilled', 1, 1),
(25, 'Tandoori Tarkari', 'ic_tandooritarkari.jpg', 279, 0, 'Fresh Cottage Cheese, Potatoes, Mushroom, Cauliflower Marinated and Grilled', 1, 1),
(26, 'Palak Makai Seekh', 'ic_palakmakaiseekh.jpg', 279, 0, 'Spinach and Corn Mixed in spl. Masala and Grilled', 1, 1),
(27, 'Lasooni Paneer Tikka', 'ic_lasoonipaneertikka.jpg', 279, 0, 'Fresh Cottage Cheese Marinated in Yoghurt, Garlic Paste, spiced and Grilled', 1, 1),
(28, 'Tandoori Paneer Tikka', 'ic_buttergarlicmushroom.jpg', 279, 0, 'Fresh Cottage Cheese Marinated in Yoghurt, Red Chilli Paste and Spices and Grilled', 1, 1),
(29, 'Paneer Hari Mirch Tikka', 'ic_palakharimirchtikka.jpg', 299, 0, 'Fresh Cottage Cheese Marinated in Yoghurt, Green Chilli Paste, Spices and Grilled', 1, 1),
(30, 'Paneer Peeli Mirch Tikka', 'ic_paneerpeelimirchtikka.jpg', 299, 0, 'Fresh Cottage Cheese Marinated in Yoghurt, Yellow Chilli Paste and Grilled', 1, 1),
(31, 'Veg Platter', 'ic_vegplatter.jpg', 939, 0, 'An Assortment of our finest Kebabs', 1, 1),
(32, 'Butter Garlic Rawas', 'ic_buttergarlicrawas.jpg', 439, 1, 'Cubed Fish Marinated with butter, Garlic, Special In House Masala and Grilled', 1, 1),
(33, 'Rawas Tandoori', 'ic_rawastandoori.jpg', 439, 1, 'Cubed fish Marinated in Tandoori Spices', 1, 1),
(34, 'Fish Ajwain Tikka', 'ic_fishajwaintikka.jpg', 439, 1, 'Cubed Fish Marinated in Special Spices', 1, 1),
(35, 'Pomfret Fry', 'ic_pomfretfry.jpg', 439, 1, 'Whole Promfet Masala Fried', 1, 1),
(36, 'Jhinga (Fry/Tandoori)', 'ic_jhinga.jpg', 499, 1, 'Fresh Prawns Masala Fried or Grilled', 1, 1),
(37, 'Zaytuni Jhinga', 'ic_zaytunijhinga.jpg', 519, 1, 'Fresh Prawns Marinated in Olive Oil, Spices and Grilled', 1, 1),
(38, 'Special Murgh Tandoori', 'ic_nonvegplatter.jpg', 399, 1, 'Whole Chicken Marinated in Yoghurt, Red Chilli Paste, Special In House Spices and Grilled', 1, 1),
(39, 'Special Afghani Murgh Tandoori', 'ic_chickenplatter.jpg', 429, 1, 'Dreamy Whole Chicken Marinated in Yoghurt, garli, Special In House Spices and Grilled', 1, 1),
(40, 'Special Murgh Charga', 'ic_nonvegplatter.jpg', 429, 1, 'Whole Chicken in a spicy Masala and Fried', 1, 1),
(41, 'Murgh Tangdi Kulfi Kebab', 'ic_chickenplatter.jpg', 339, 1, 'Chicken Drumsticks Marinated in Special Tandoori Masala', 1, 1),
(42, 'Murgh Tangdi Kebab', 'ic_nonvegplatter.jpg', 339, 1, 'Chicken Drumsticks Marinatedin Cream, Herbs, Wrapped in a Silver Foil cooked in Tandoor', 1, 1),
(43, 'Murgh Pankhuri Kebab - Our Special', 'ic_chickenplatter.jpg', 299, 1, 'Chiken Wings Marinated in Special Spices and Grilled', 1, 1),
(44, 'Murgh Malai Tikka', 'ic_murghmalaitikka.jpg', 299, 1, 'Creamy Chicken Cubes Marinated and Grilled, Non Spicy', 1, 1),
(45, 'Murgh Lasooni Tikka', 'ic_murghlasoonitikka.jpg', 299, 1, 'Creamy Chicken Cubes Marinated with Garlic, Herbs and Grilled', 1, 1),
(46, 'Murgh Kalimiri Tikka', 'ic_murghkalimiritikka.jpg', 299, 1, 'Creamy Chicken Cubes Marinated, Spiced with Crushed Peppercorns and Grilled', 1, 1),
(47, 'Murgh Tikka', 'ic_murghtikka.jpg', 299, 1, 'Chicken Cubes Marinated in Yoghurt, Red Chilli Paste, Spices and Grilled', 1, 1),
(48, 'Murgh Hari Mirch Tikka', 'ic_murghharimirchtikka.jpg', 299, 1, 'Chicken Cubes Marinated in Yoghurt, Green Chilli Paste, Spices and Grilled', 1, 1),
(49, 'Murgh Peeli Mirch Tikka', 'ic_murghpeelimirchtikka.jpg', 299, 1, 'Chicken Cubes Marinated in Yoghurt, Yellow Chilli Paste, Spices and Grilled', 1, 1),
(50, 'Murgh Seekh Kebab', 'ic_murghseekhkebab.jpg', 299, 1, 'Minced Chicken Scrambled, Rolled in Dried Tomatoes, Onion, Capsicum Mildly Spiced and Grilled', 1, 1),
(51, 'Murgh Chapli Kebab', 'ic_murghchaplikebab.jpg', 299, 1, 'Minced Chicken with Chopped Onions, Coriander, Whol Masala and Pan Fried', 1, 1),
(52, 'Murgh Potli Kebab', 'ic_murghpotlikebab.jpg', 329, 1, 'Minced Chicken Stuffed in Chicken Filled with Chef, Special Spices and Grilled', 1, 1),
(53, 'Gosht Seekh Kebab', 'ic_goshtseekhkebab.jpg', 329, 1, 'Minced Lamb Skewered with In-House Spices and Grilled', 1, 1),
(54, 'Raan Tandoori', 'ic_raantandoori.jpg', 1759, 1, 'Leg of Lamb Marinated in Whole Spices, Malt Vinegar and Grilled', 1, 1),
(55, 'Dum Aloo Kashmiri', 'ic_dumalookashmiri.jpg', 239, 0, 'Baby Potatoes Cooked in a Delicious Sami Gravy', 1, 2),
(56, 'Kadai Subzi', 'ic_kadaisubzi.jpg', 249, 0, 'Veggies Cooked in a Spiced Onion Tomato Gravy', 1, 2),
(57, 'Veg. Jalfrezi', 'ic_vegjalfrezi.jpg', 249, 0, 'Assortment of Vegetables Stir friedin Indian Masala', 1, 2),
(58, 'Babycorn Mushroom Masala', 'ic_babycornmushroommasala.jpg', 279, 0, 'Babycorn and Button Mushroom Simmered in Spicy Masala Gravy', 1, 2),
(59, 'Paneer Makhanwala', 'ic_paneermakhanwala.jpg', 299, 0, 'Cottage Cheese in Butter Tomato GravyFlavoured with Dry Fenugreek.', 1, 2),
(60, 'Paneer Sia Mirch', 'ic_paneersiamirch.jpg', 269, 0, 'Cottage Cheese Cooked in an In-House Kadai Masala with Capsicum and Onions', 1, 2),
(61, 'Palak Paneer', 'ic_palakpaneer.jpg', 269, 0, 'Cottage Cheese Cooked in Spinach Gravy Mildly Spiced', 1, 2),
(62, 'Paneer Tikka Masala', 'ic_paneertikkamasala.jpg', 299, 0, 'Paneer Tikka in Spicy Butter Tomato Gravy', 1, 2),
(63, 'Paneer Lahori', 'ic_paneerlahori.jpg', 269, 0, 'Cottage Cheese Cooked with Masala Imported from Lahore', 1, 2),
(64, 'Paneer Tawa Khurchan', 'ic_paneertawakhurchan.jpg', 269, 0, 'Cottage Cheese Minced and Stir on Tawa', 1, 2),
(65, 'Shahi Paneer', 'ic_shahipaneer.jpg', 299, 0, 'Cottage Cheese Cookedin Cherry Tomato Gravy, and In-House Speciality', 1, 2),
(66, 'Dal Tadka', 'ic_daltadka.jpg', 189, 0, 'Yellow Lentils Cooked and tempered with Desi Ghee', 1, 2),
(67, 'Dum Ki Dal', 'ic_dumkidaal.jpg', 229, 0, 'Black Lentils Simmered with Tomato Puree and White Butter Cooked Overnight', 1, 2),
(68, 'Murgh Dahiwala', '', 309, 1, 'Boned Chicken Simmered in a Mildly Spiced Yoghurt Gravy', 1, 2),
(69, 'Murgh Sia Mirch', '', 309, 1, 'Chicken Cooked in an In-House Kadai Masala with Capsicum and Onions', 1, 2),
(70, 'Murgh Hara Masala', '', 309, 1, 'Boned Chicken Simmered in Coriander and Green Chilli Based Gravy', 1, 2),
(71, 'Murgh Chilli Fry', '', 339, 1, 'Chicken Fired with Marinated Cheese with Chilli Paste and In-House Kadai Masala', 1, 2),
(72, 'Murgh Matka', '', 309, 1, 'Chicken Cubes Cooked in Special Spices and Gravy Mildly Spiced', 1, 2),
(73, 'Murgh Makhanwala Special', '', 339, 1, 'A Classic Chicken Gravy in Butter Tomato Gravy Flavoured with Fried Feungreek', 1, 2),
(74, 'Murgh Tikka Masala', '', 339, 1, 'Chicken Tikka Cooked in Spicy Butter Tomato Gravy', 1, 2),
(75, 'Murgh Istew', '', 309, 1, 'Special Chicken Curry Cooked With Pounded Indian Spices and Red Chillies', 1, 2),
(76, 'Murgh Karachi', '', 329, 1, 'Boned Chicken Cooked in a Brown Onion Gravy with Spicy Masala from Karachi', 1, 2),
(77, 'Murgh Lahori', '', 339, 1, 'Chicken Cokked with Imported Masala From Lahore', 1, 2),
(78, 'Murgh Tawa Khurchan', '', 339, 1, 'Shredded Chicken Tossed with Bell Pepper, Onion, Cooked with Indian Spices', 1, 2),
(79, 'Murgh Ghee Roast', '', 339, 1, 'Chicken with Whole Spices Roasted in Ghee', 1, 2),
(80, 'Murgh Korma', '', 329, 1, 'Age Old Style Preparation Cooked in a Copper Vessel', 1, 2),
(81, 'Murgh Mussallam(H/F)', '', 499, 1, 'Whole Grilled Tandoori Chicken Tossed in Spicy Butter Tomato Gravy served on a Bed of Pulao', 1, 2),
(82, 'Hari Mirch Ka Kheema', '', 369, 1, 'Home Style Mutton Minced cooked with Indian Spices', 1, 2),
(83, 'Gosht Chilly Fry', '', 449, 1, 'Marinated Fried Piece of Mutton Flavoured with Curry Leaves and Chilly in a Spicy Sauce', 1, 2),
(84, 'Gosht Istew', '', 429, 1, 'Special Mutton Curry Cooked with Pounded Indian Spices and Red Chillies', 1, 2),
(85, 'Gosht Karachi', '', 429, 1, 'Boned Mutton Cooked in a Brown Onion Gravywith a Spicy Masala from Karachi', 1, 2),
(86, 'Gosht Nihari', '', 429, 1, 'Traditional Pakistani Lamb Curry', 1, 2),
(87, 'Gosht Korma', '', 429, 1, 'Age Old Style Preparation Cooked in a Copper Vessel', 1, 2),
(88, 'Gosht Roganjosh', '', 429, 1, 'Classic North Indian Lamb Curry', 1, 2),
(89, 'Dun Ka Jeera Gosht', '', 429, 1, 'Curry Cut Lamb Cooked with Spicy Masala Topped with Royal Cummin', 1, 2),
(90, 'Dum Ki Chaap', '', 429, 1, 'Lamb Chops Marinated with indian Spices Cokked on Slow Fire', 1, 2),
(91, 'Gosht Matka', '', 429, 1, 'Mutton Cooked in Special Spices and Gravy, Mildly Spiced', 1, 2),
(92, 'Bheja Masala', '', 369, 1, 'Brain of Lamb Cooked in Spicy Dry Masala', 1, 2),
(93, 'Gosht Ghee Roast', '', 449, 1, 'Mutton with Whole Spices Roasted in Ghee Finish in Tangy Tamarind Sauce', 1, 2),
(94, 'Raan Masala', '', 1979, 1, 'Leg of Baby Lamb Marinated in Whole Spices, Malt Vinegar, Grilled and tossed in Spicy Tomato Gravy', 1, 2),
(95, 'Raan Mussallam Thaal', '', 2419, 1, 'Leg of Baby Lamb Marinated in Whole Spices, Malt Vinegar, Grilled and tossed in Spicy Tomato Gravy served on the Bed of safforn Pulao', 1, 2),
(96, 'Tandoori Roti', 'ic_tandoori roti.jpg', 29, 0, 'Wheat Bread Cooked in Tandoor', 1, 3),
(97, 'Butter Roti', 'ic_butter roti.jpg', 39, 0, 'Wheat Bread Cooked in Tandoor and Served with Butter', 1, 3),
(98, 'Naan', 'ic_naan.jpg', 39, 0, 'Maida Bread Cooked in Tandoor', 1, 3),
(99, 'Butter Naan', 'ic_butternaan.jpg', 49, 0, 'Maida Bread Cooked in Tandoor and Served with Butter', 1, 3),
(100, 'Garlic Naan', 'ic_garlicnaan.jpg', 59, 0, 'Maida Bread Cooked with Garlic Paste in Tandoor and Served with Butter', 1, 3),
(101, 'Cheese Naan', 'ic_cheesenaan.jpg', 69, 0, 'Maida Bread Cooked in Tandoor and Served with Cheese', 1, 3),
(102, 'Cheese Garlic Naan', 'ic_cheesegarlicnaan.jpg', 79, 0, 'Maida Bread Cooked in Tandoor along with Garlic Paste and Served with Cheese', 1, 3),
(103, 'Cheese Chilli Naan', 'ic_cheesechillinaan.jpg', 79, 0, 'Maida Bread Cooked in Tandoor and Sreved with Mild Chilli Paste and Served with Cheese', 1, 3),
(104, 'Lacchedaar Paratha', '', 49, 0, 'Lacchedaar Paratha is a Special Type of Indian Bread.', 1, 3),
(105, 'Roomali Roti', '', 49, 0, 'Roomali Roti is a Special Type of Indian Bread.', 1, 3),
(106, 'Steam Rice', '', 139, 0, 'Simple Boiled Rice', 1, 2),
(107, 'Dum Ke Chawal', '', 159, 0, 'Boiled Rice Served on a Bed of Potatoes', 1, 2),
(108, 'Peas Pulao', '', 169, 0, 'Boiled Rice Served with Fried Peas.', 1, 2),
(109, 'Jeera Rice', '', 169, 0, 'Boiled Rice Served with Jeera.', 1, 2),
(110, 'Veg Dum Biryani', '', 199, 0, 'Fried Rice Served on a Bed of Potatoes', 1, 2),
(111, 'Paneer Tikka Biryani', '', 319, 0, 'Fried Rice Served with Paneer Tikka Mixed.', 1, 2),
(112, 'Murgh Dum Biryani', '', 239, 1, 'Fried Rice Served with Chicken Mixed Served on Bed of Potatos.', 1, 2),
(113, 'Murgh Dum Biryani (Boneless)', '', 299, 1, 'Fried Rice Served with Boneless Chicken Mixed Served on Bed of Potatos.', 1, 2),
(114, 'Murgh Tikka Dum Biryani', '', 329, 1, 'Fried Rice Served with Chicken Tikka Mixed Served on Bed of Potatos.', 1, 2),
(115, 'Gosht Dum Biryani', '', 329, 1, 'Fried Rice Served with Lamb Mixed Served on Bed of Potatos.', 1, 2),
(116, 'Gosht Dum Biryani (Boneless)', '', 329, 1, 'Fried Rice Served with Boneless Lamb Mixed Served on Bed of Potatos.', 1, 2),
(117, 'Raan Biryani', '', 2649, 1, 'Fried Rice Served with Baby Lamb Mixed Served on Bed of Potatos.', 1, 2),
(118, 'Roated Papad', '', 19, 0, 'Dry Bead', 1, 2),
(119, 'Fried Papad', '', 29, 0, 'Fried Dry Bread', 1, 2),
(120, 'Masal Papad', '', 39, 0, 'Masala Dry Bread', 1, 2),
(121, 'Bhurani Raita', '', 89, 0, 'Bhurani Mixed in Yoghurt.', 1, 2),
(122, 'Boondi Raita', '', 89, 0, 'Boondi Mixed in Yoghurt.', 1, 2),
(123, 'Mix Veg Raita', '', 89, 0, 'Veggies Mixed in Yoghurt.', 1, 2),
(124, 'Green Salad', '', 89, 0, 'Salad Consisting of Onions, Tomatoes, Cucumbers, Carrot.', 1, 2),
(182, 'Malai Firni', 'ic_malaiphirni.jpg', 119, 0, 'Kheer.', 1, 4),
(183, 'Caramel Custard', 'ic_caramelcustard.jpg', 129, 0, 'Custard with Caramel Layer on the Top.', 1, 4),
(184, 'Shahi Tukda', 'ic_shahitukra.jpg', 129, 0, 'Fresh Cream Topping with Dry Fruits on Bread.', 1, 4),
(185, 'Doodhi halwa', 'ic_doodhihalwa.jpg', 129, 0, 'Bottle Gourd Halwa.', 1, 4),
(186, 'Chocolate Frappe', 'ic_chocolatefrappe.jpg', 199, 0, 'Chocolate milk shake with cream layering', 1, 4),
(187, 'Chocolate Brownie with Ice-Cream', 'ic_chocolatebrowniewithicecream.jpg', 139, 0, 'Chocolate Brownie served with Ice-Cream of choice', 1, 4),
(188, 'Black Forest Sundae', 'ic_blackforestsundae.jpg', 219, 0, 'Black Forest Ice-Cream', 1, 4),
(189, 'Gulab Jamun with Ice-Cream', 'ic_gulabjamunwithicecream.jpg', 109, 0, 'Gulab Jamun served with ice-cream of choice', 1, 4),
(197, 'Bottled Water', 'ic_bottledwater.jpg', 49, 0, 'Bisleri.', 1, 5),
(198, 'Aerated Drinks', 'ic_aerateddrinks.jpg', 59, 0, 'Thumbs Up, Dew, 7UP', 1, 5),
(199, 'Chaas', 'ic_chass.jpg', 89, 0, 'Butter Milk', 1, 5),
(200, 'Sweet Lassi', 'ic_sweetlassi.jpg', 89, 0, 'Sweetened Milk', 1, 5),
(201, 'Fresh Lime Water', 'ic_freshlimewater.jpg', 59, 0, 'Nimbu Paani.', 1, 5),
(202, 'Fresh Soda Lime', 'ic_freshsodalime.jpg', 69, 0, 'Abdul Ka Soda.', 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` int(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `food_id` int(100) NOT NULL,
  `rating` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `email`, `food_id`, `rating`) VALUES
(10, 'naman7kumar@gmail.com', 3, 4),
(11, 'naman7kumar@gmail.com', 1, 2.5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `user_image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `user_name`, `email`, `user_image`) VALUES
(1, 'prashant', 'krishna@gmail.com', ''),
(9, 'shivam', 'abc@gmail.com', 'asdfg'),
(10, 'Naman Kumar', 'naman7kr@gmail.com', 'null'),
(11, 'Naman Kumar', 'naman7kumar@gmail.com', 'https://lh6.googleusercontent.com/-2_aqgygDK9k/AAAAAAAAAAI/AAAAAAAAE8I/A1gS3s5GMcI/photo.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `waiter`
--

CREATE TABLE `waiter` (
  `id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `contact_no` varchar(13) NOT NULL,
  `table_no` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `waiter`
--

INSERT INTO `waiter` (`id`, `name`, `contact_no`, `table_no`) VALUES
(1, 'Raju', '1234567890', '123'),
(2, 'Chotu', '2134567890', '1244'),
(3, 'Ron Will', '1314567890', '3'),
(4, 'yoyo', '9876543210', '5'),
(5, 'Grant ward', '8976543210', '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food_items`
--
ALTER TABLE `food_items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `waiter`
--
ALTER TABLE `waiter`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food_items`
--
ALTER TABLE `food_items`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203;
--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `waiter`
--
ALTER TABLE `waiter`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
