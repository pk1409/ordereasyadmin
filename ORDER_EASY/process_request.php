<?php 
	
	require("connection.php");

	/* sends four food item of each type for home page*/

	if(isset($_POST['home'])){

		$array=array();

		$cnt=0;
		$user_id=$_POST['home'];
		//$user_id="mkj@gmail.com";

		$query="SELECT foodID FROM recommended WHERE userID='$user_id' AND foodID!=0 LIMIT 4";
		$result= mysqli_query($conn,$query);
		if(mysqli_num_rows($result)>0){

			while($row=mysqli_fetch_assoc($result)){
				
				$food_id=$row['foodID'];
				//echo $food_id." ";
				$query1="SELECT * FROM food_items WHERE id='$food_id'";
				$result1= mysqli_query($conn,$query1);

				$row1=mysqli_fetch_assoc($result1);

				$array["food_items"][$cnt]['id']=$row1['id'];
				$array["food_items"][$cnt]['name']=$row1['name'];
				$array["food_items"][$cnt]['image']=$row1['image'];
				$array["food_items"][$cnt]['price']=$row1['price'];
				$array["food_items"][$cnt]['category']=$row1['category'];
				$array["food_items"][$cnt]['description']=$row1['description'];
				$array["food_items"][$cnt]['quantity_type']=$row1['quantity_type'];
				$array["food_items"][$cnt]['item_type']=0;
				//echo $array[0][$cnt]['name'];
				$cnt=$cnt+1;

			}
		}
		
		for($i=1;$i<=5;$i++){

			$query="SELECT * FROM food_items WHERE item_type=$i LIMIT 4 ";
			$result= mysqli_query($conn,$query);
			if(mysqli_num_rows($result)>0){

				while($row=mysqli_fetch_assoc($result)){

					$array["food_items"][$cnt]['id']=$row['id'];
					$array["food_items"][$cnt]['name']=$row['name'];
					$array["food_items"][$cnt]['image']=$row['image'];
					$array["food_items"][$cnt]['price']=$row['price'];
					$array["food_items"][$cnt]['category']=$row['category'];
					$array["food_items"][$cnt]['description']=$row['description'];
					$array["food_items"][$cnt]['quantity_type']=$row['quantity_type'];
					$array["food_items"][$cnt]['item_type']=$row['item_type'];
					//echo $array[0][$cnt]['name'];
					$cnt=$cnt+1;

				}
			}

		}
		
		//print_r($array);
		$data=json_encode($array);
		echo $data;

	}

	/* sends all food items  */

	if(isset($_POST['all'])){

		$array=array();
		
		$cnt=0;
		$user_id=$_POST['all'];
		//$user_id="mkj@gmail.com";

		$query="SELECT foodID FROM recommended WHERE userID='$user_id' AND foodID!=0";
		$result= mysqli_query($conn,$query);
		if(mysqli_num_rows($result)>0){

			while($row=mysqli_fetch_assoc($result)){

				$food_id=$row['foodID'];
				$query1="SELECT * FROM food_items WHERE id='$food_id'";
				$result1= mysqli_query($conn,$query1);

				$row1=mysqli_fetch_assoc($result1);

				$array["food_items"][$cnt]['id']=$row1['id'];
				$array["food_items"][$cnt]['name']=$row1['name'];
				$array["food_items"][$cnt]['image']=$row1['image'];
				$array["food_items"][$cnt]['price']=$row1['price'];
				$array["food_items"][$cnt]['category']=$row1['category'];
				$array["food_items"][$cnt]['description']=$row1['description'];
				$array["food_items"][$cnt]['quantity_type']=$row1['quantity_type'];
				$array["food_items"][$cnt]['item_type']=0;
				//echo $array[0][$cnt]['name'];
				$cnt=$cnt+1;

			}
		}

		$query="SELECT * FROM food_items";
		$result= mysqli_query($conn,$query);
		
		if(mysqli_num_rows($result)>0){
			
			while($row=mysqli_fetch_assoc($result)){

				$array["food_items"][$cnt]['id']=$row['id'];
				$array["food_items"][$cnt]['name']=$row['name'];
				$array["food_items"][$cnt]['image']=$row['image'];
				$array["food_items"][$cnt]['price']=$row['price'];
				$array["food_items"][$cnt]['category']=$row['category'];
				$array["food_items"][$cnt]['description']=$row['description'];
				$array["food_items"][$cnt]['quantity_type']=$row['quantity_type'];
				$array["food_items"][$cnt]['item_type']=$row['item_type'];
				//echo $array[0][$cnt]['name'];
				$cnt=$cnt+1;

			}
		}		

		$data=json_encode($array);
		echo $data;

	}
	
	/*return table_no of waiter*/
	
	else if(isset($_POST['table_waiter'])){
		
		$array= array();
		
		$username=$_POST['table_waiter'];
		
		$query1="SELECT table_no FROM waiter WHERE username=$username";
		$result1=mysqli_query($conn,$query1);
		
		if(mysqli_num_rows($result1)>0){

			$row=mysqli_fetch_assoc($result1);
			
			$array['table_no'][0]=$row['table_no'];
			
		}
		
		$data=json_encode($array);
		echo $data;
		
	}
	
	/*	waiter assign part		*/
	
	
	else if(isset($_POST['waiter_table'])){
		//$table_no="124";
		
		$table_no=$_POST['waiter_table'];
		$array=array();
		$query1="SELECT * FROM waiter WHERE table_no=$table_no";
		$result1=mysqli_query($conn,$query1);

		if(mysqli_num_rows($result1)>0){

			$row=mysqli_fetch_assoc($result1);

			$array['id']=$row['id'];
			$array['name']=$row['name'];
			$array['contact_no']=$row['contact_no'];
			$array['table_no']=$table_no;
		}
		else{
			$query="SELECT * FROM waiter ORDER BY table_no limit 1";
			$result= mysqli_query($conn,$query);

			if(mysqli_num_rows($result)>0){
			
				$row=mysqli_fetch_assoc($result);

				if($row['table_no']!="0")
					$id='0';
				else
					$id=$row['id'];

				$array['id']=$id;
				$array['name']=$row['name'];
				$array['contact_no']=$row['contact_no'];
				$array['table_no']=$table_no;

			}
			if($id!='0'){
				$id=$array['id'];

				$query="UPDATE waiter set table_no=$table_no where id=$id";
				$result= mysqli_query($conn,$query);
			}
		}

		$data=json_encode($array);
		echo $data;
	}

	/* details of the food_items assigned to a waiter */

	else if(isset($_POST['waiter_details'])){

		//$table_no=32;
		$table_no=$_POST['waiter_details'];
		$array= array();

		$query="SELECT * FROM store_order WHERE table_no=$table_no";
		$result=mysqli_query($conn,$query);

		$cnt=0;

		if(mysqli_num_rows($result)>0){

			while($row=mysqli_fetch_assoc($result)){

				$array["food_items"][$cnt]['food_name']=$row['food_name'];
				$array["food_items"][$cnt]['table_no']=$row['table_no'];
				$cnt=$cnt+1;

			}
		}

		$data=json_encode($array);
		echo $data;

	}
	
	
	/*	waiter remove hoga 	*/
	
	
	else if(isset($_POST['waiter_remove'])){
		//$id=2;
		$id=$_POST['waiter_remove'];

		$query="SELECT table_no FROM waiter where id=$id";
		$result= mysqli_query($conn,$query);

		$row=mysqli_fetch_assoc($result);
		$table_no=$row['table_no'];

		$query="UPDATE waiter set table_no='0' where id=$id";
		$result= mysqli_query($conn,$query);


		$query="DELETE FROM store_order where table_no='$table_no'";
		$result= mysqli_query($conn,$query);


		//$data=json_encode($array);
		//echo $data;
	}

	/*	new user entry in user table & set rating of all items of that user in review table to 0.0  */
	
	else if(isset($_POST['user_entry'])){

		$json=$_POST['user_entry'];

		//$filename = "../test json file/order_test.json";

		//$json = file_get_contents($filename);

		$data=json_decode($json,true);
		
		$user_name=$data['username'];
		$email=$data['email'];
		$img=$data['img'];
		
		//echo $user_name." ".$email;

		if($user_name&&$email){

			$query="SELECT email FROM user WHERE email='$email'";
			$result= mysqli_query($conn,$query);
			
			if(mysqli_num_rows($result)==0){

				$query="INSERT INTO user (id,user_name, email, user_image) VALUES (NULL,'$user_name','$email','$img')";
				$result= mysqli_query($conn,$query);
				
				$query1 = "SELECT id FROM food_items";
				$result1 = mysqli_query($conn,$query1);
				
				if(mysqli_num_rows($result1)>0){
					
					while($row1 = mysqli_fetch_assoc($result1)){
						
						$food_id = $row1['id'];
						$query3 ="INSERT INTO review (id,email,food_id,rating) VALUES(NULL,'$email','$food_id',0.0)";
						$result2 = mysqli_query($conn,$query3);
					}
				}
			}
		}
	}	

	
	/*store the review given by user*/

	else if(isset($_POST['review_entry'])){

		$json=$_POST['review_entry'];

		//$filename = "test.json";

		//$json = file_get_contents($filename);

		$data=json_decode($json,true);

		for($i=0;$i<sizeof($data);$i++){

			$email=$data[$i]['email'];
			$food_id=$data[$i]['food_id'];
			$rating=$data[$i]['rating'];

			if($email&&$food_id&&$rating){
				//echo $email." ".$food_id." ".$rating;
				
				$query="UPDATE review set rating='$rating' where email='$email' AND food_id='$food_id'";
				$result= mysqli_query($conn,$query);
				
			}
		}
	}

	else if(isset($_POST['store_order'])){

		$json=$_POST['store_order'];

		$test=array();

		// $test[0]['food_id']=14;
		// $test[0]['qty']=1;
		// $test[0]['table_no']=32;
		
		// $test[1]['food_id']=20;
		// $test[1]['qty']=1;
		// $test[1]['table_no']=32;

		// $json=json_encode($test);

		$data=json_decode($json,true);

		$food="";

		for($i=0;$i<sizeof($data);$i++){
			
			$food_id=$data[$i]['food_id'];
			$qty = $data[$i]['qty'];
			$table_no = $data[$i]['table_no'];
			
			$query="SELECT name FROM food_items WHERE id=$food_id";
			$result=mysqli_query($conn,$query);

			$row=mysqli_fetch_assoc($result);
			$name=$row['name'];
			
			$food=$food.$name." -> ".$qty." , ";

		}
		$flag=0;

		//echo $food;

		$query1 = "INSERT INTO store_order (id,food_name,table_no,flag) VALUES(NULL,'$food','$table_no','$flag')";
		$result1 = mysqli_query($conn,$query1);

	}

	/*send order to cook*/

	else if(isset($_POST["cook_order"])){


		$array= array();

		$query="SELECT * FROM store_order WHERE flag=0";
		$result=mysqli_query($conn,$query);

		$cnt=0;

		if(mysqli_num_rows($result)>0){

			while($row=mysqli_fetch_assoc($result)){

				$array["food_items"][$cnt]['food_name']=$row['food_name'];
				$array["food_items"][$cnt]['table_no']=$row['table_no'];
				$cnt=$cnt+1;

			}
		}

		$query="UPDATE store_order SET flag=1 WHERE flag=0";
		$result=mysqli_query($conn,$query);

		$data=json_encode($array);
		echo $data;

	}

	mysqli_close($conn);

?>