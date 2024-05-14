from datetime import datetime
from datetime import timedelta
import random
import os

nested_list = []

try:  # Perform exception handling for opening file
    with open('reservation_22031645.txt', 'r+') as file_R:
        for line in file_R:  # Read reservation_22031645.txt file and convert into nested list according to each date
            parts = line.strip().split('|')

            if len(parts) >= 3:  # Ensure enough elements in the parts list
                date = parts[0]
                slot = int(parts[1].split(' ')[1])
                customer_details = parts[2:]

                # Check if the date exists in the nested list
                date_exists = False
                for entry in nested_list:
                    if entry[0] == date:
                        date_exists = True
                        entry[1][slot - 1].append(customer_details)
                        break

                if not date_exists:
                    slot_list = [[] for _ in range(4)]
                    slot_list[slot - 1].append(customer_details)
                    nested_list.append([date, slot_list])


        # Function to find the matching date in the nested list with the user input date
        def match_date_input(user_booking_date_str):
            matching_date = []
            for entry in nested_list:
                # checking the first item of the list whether it matches with user input date 
                if entry[0] == user_booking_date_str:
                    matching_date.append(entry) # if matches, it will append into empty matching_date list
              
            return matching_date


        # function to find the matching slot in the nested list with the user input slot
        def match_slot_input(slot, matched_date):
            matching_slot = []
            if matched_date and len(matched_date[0][1]) > slot:
                matching_slot = matched_date[0][1][slot]  # Assign the slot_list in to mactching_slot 
              
            return matching_slot


        # function to find matching name and phone in the nested list with the user input.
        def match_name_phone(matched_slot, name_str, phone_num_str):
            # assign as none so that if matching cannot be found, return as none and later can print error message
            matched_user_info = None
            
            for user_info in matched_slot:
                os.system('cls')
                if name_str in user_info and phone_num_str == user_info[2]:
                    print(f"\nReservation details: \n\n1. Name: {user_info[0]}\n\n2. Email: {user_info[1]}\n\n3. Phone number: {user_info[2]}\n\n4. Pax: {user_info[3]}")
                    matched_user_info = user_info # Assign it to matche_user_info
                    break

            return matched_user_info


        # Function for matching user input
        def match_reservation():
            # Ask user to input date, slot, name, and phone number to find a matching in nested_list
            print("\nPlease provide the information below to find your reservation")

            while True:
                try:
                    user_booking_date = input("\nEnter the reservation date ['YYYY-MM-DD'] : ")
                    user_booking_date = datetime.strptime(user_booking_date, "%Y-%m-%d").date()
                    break

                except:
                    print("\nINVALID DATE!", "\nPlease enter the correct format or a valid date.")
            # Call match_date_input to check the date in nested_list   
            user_booking_date_str = str(user_booking_date) # Assigning it into string to be able to find in nested_list
            matched_date = match_date_input(user_booking_date_str) # Call match_date_input to check the date in nested_list 

            
            repeat_slot = True
            while repeat_slot:
                try:
                    slot = int(input("\nEnter the reservation slot number [1-4]: "))
                    if 1 <= slot <= 4: # Catching the error
                        repeat_slot = False

                    else:
                        print("\nEnter the slot number between 1 and 4 only!")

                except: # if user enter string, this will be print
                    print("\nINVALID SLOT! \nPlease enter the right format or data type.")
            # Call match_slot_input to check the slot
            matched_slot = match_slot_input(slot - 1, matched_date) # slot - 1 to match the index that represent each slots

            # Call enter_name and enter_phone_number function to catch the error
            name = enter_name()
            phone_num = enter_phone_number()

            # looping back until it found a match
            matched = False
            if not matched:
                matched_user_info = match_name_phone(matched_slot, name, phone_num)

                if matched_user_info is not None:
                    matched = True
                  
                else:
                    os.system('cls')
                    print("\nYour reservation input can't be found in our database. \nPlease enter all the information again. \n")
                    # Call the function again to start from the beginning
                    matched_user_info = match_reservation()

            return matched_user_info


        # Function to delete reservation if reservation can be found.
        def delete_reservation(matched_user_info):
            if matched_user_info:  # Iterate in nested list to find reservation
                for entry in nested_list:
                    for slot_list in entry[1]:
                        if matched_user_info in slot_list:
                            slot_list.remove(matched_user_info)  # Delete reservation if found
                            break
                          
            else:
                print("\nReservation not found.")

            return nested_list


        # Function to convert a nested list to text file
        def nested_list_to_text_file(nested_list, file_R):
            for entry in nested_list:
                date = entry[0]
                for slot_index, slot_list in enumerate(entry[1]): # Iterate every list within slot_list which is entry index 1
                    for customer_details in slot_list: 
                        parts = [str(date), f"Slot {slot_index + 1}"] # Creating a list that have date in string type and f-sting slot 
                        parts.extend(map(str, customer_details)) # Adding elemtent in the customer_details to parts list in string
                        line = '|'.join(parts) # Connecting elements in the parts list using '|'
                        file_R.write(line + '\n') # Writing the line to the file 
                        file_R.flush() # Writing to the file immediately


        # Function to enter the number of pax for a reservation
        def enter_numpax():
            repeat_numpax = True
            while repeat_numpax:
                try:
                    num_pax = int(input("\nEnter the number of pax: "))
                    # Perform exception handling to only accept 1-4 and nothing else
                    while num_pax <= 0 or num_pax >= 5:
                        print("\nNumber of pax is limited within 1 to 4 only !!")
                        num_pax = int(input("\nEnter the number of pax: "))
                    if num_pax in range(1, 5):  # repeat_numpax will stop when it is a valid input (1-4)
                        repeat_numpax = False
                      
                except ValueError:
                    print("\nNumber of pax is limited within 1 to 4 only !!")
                  
            return num_pax


        # Function to enter phone number of customer
        def enter_phone_number():
            repeat_phone = True
            while repeat_phone:
                phone = input("\nEnter phone number (starts with 601XXXXXXXX): ")
                # Perform exception handling for checking the length of phone number (11-12 digits including leading 6)
                while len(phone) <= 10 or len(phone) >= 13:
                    print(
                        "\nPhone number should start with 601XXXXXXXX !\n\nThe length of phone number should be within 11-12 digits!!")
                    phone = input("\nEnter phone number: ")
                # Perform exception handling to check whether the phone number starts from "601XXXXXXXXX"
                if phone[0] != '6' or phone[1] != '0' or phone[2] != '1':
                    print("\nPhone number should start with 601XXXXXXXX !!")

                elif not phone[0:].isdigit():
                    print("\nInvalid format. There should be only digits accepted!!")
                    print("\nPhone number should start with 601XXXXXXXX !!")

                else:
                    repeat_phone = False
                  
            return phone


        # Function to enter email address for customer
        def enter_email():
            repeat_email = True
            while repeat_email:
                email = input("\nEnter valid email address (Example: abc123@gmail.com): ").lower()
                # Perform exception handling to avoid user from entering invalid input
                # A valid input for email must contain "@" symbol and ".com"/".edu.my"
                # A valid input for email should only contain digits and letters
                if '@' in email and ('.com' in email or '.edu.my' in email):
                    # Split the email address into a list to check for the string before "@" symbol
                    username = email.split('@')[0]
                    if username == '':
                        print("\nInvalid format. There should be no symbols in front of '@'!!")
                    # If the string before "@" contain symbols or space, an error message will be printed
                    elif not all(char.isalpha() or char.isdigit() for char in username):
                        print("\nInvalid format. There should be no symbols in front of '@'!!")
                      
                    else:
                        repeat_email = False
                      
                else:
                    print("\nPlease include '@' and end with '.com' or '.edu.my' !!")
                  
            return email

      
        # Function to enter name
        def enter_name():
            repeat_name = True
            while repeat_name:
                name = input("\nEnter name: ").strip().upper()
                # Perform exception handling for name (it does not allow user to enter empty string)
                if name == '':
                    print("\nName cannot be empty. Please enter again.")
                  
                # Exception handling to make sure the name contains only letter
                # A valid name should only contain alphabets and space
                elif not all(char.isalpha() or char.isspace() for char in name):
                    print("\nInvalid name format. Please enter a name containing only alphabets and spaces.")
                  
                else:
                    repeat_name = False
                  
            return name


        # Function to enter the number of slot (Slot 1-4)
        def enter_slot(user_booking_date_str):

            repeat_slot = True
            while repeat_slot:
                slot = input("\nThe restaurant only serves 4 sessions each day:\n\n[1] 12:00 pm – 02:00 pm\n\n[2] 02:00 pm – 04:00 pm\n\n[3] 06:00 pm – 08:00 pm\n\n[4] 08:00 pm – 10:00 pm\n\nEnter Slot (1 to 4): ")
                # Perform exception handling for number of slot (on ly accepts 1-4 and nothing else)
                while slot not in ['1', '2', '3', '4']:
                    print("\nPlease enter only 1 to 4 for slot !!")
                    slot = input("\nEnter Slot (1 to 4): ")
                # Perform exception handling for user input besides 1 to 4
                if slot in ['1', '2', '3', '4']:
                    # If slot 1 on the particular date is fully booked (maximum 8 reservations), error message will be printed
                    if slot == '1':
                        if len(matched_date) == 0:
                            repeat_slot = False  
                          
                        elif len(matched_date[0][1][0]) >= 8:  # slot 1
                            print(f"\nSlot {slot} on {user_booking_date} is fully booked, please proceed with another booking!!")  
                          
                        else:
                            repeat_slot = False

                    # If slot 2 on the particular date is fully booked (maximum 8 reservations), error message will be printed
                    elif slot == '2':
                        if len(matched_date) == 0:
                            repeat_slot = False 
                          
                        elif len(matched_date[0][1][1]) >= 8:  # slot 2
                            print(f"\nSlot {slot} on {user_booking_date} is fully booked, please proceed with another booking!!") 
                          
                        else:
                            repeat_slot = False

                    # If slot 3 on the particular date is fully booked (maximum 8 reservations), error message will be printed
                    elif slot == '3':
                        if len(matched_date) == 0:
                            repeat_slot = False  
                          
                        elif len(matched_date[0][1][2]) >= 8:  # slot 3
                            print(f"\nSlot {slot} on {user_booking_date} is fully booked, please proceed with another booking!!")  
                          
                        else:
                            repeat_slot = False

                    # If slot 4 on the particular date is fully booked (maximum 8 reservations), error message will be printed
                    elif slot == '4':
                        if len(matched_date) == 0:
                            repeat_slot = False
                          
                        elif len(matched_date[0][1][3]) >= 8:  # slot 4
                            print(
                                f"\nSlot {slot} on {user_booking_date} is fully booked, please proceed with another booking!!")  
                          
                        else:
                            repeat_slot = False

                    else:
                        print("\nEnter only 1 to 4 and nothing else!!")

            return slot  


        # Function for user to enter the date they want to reserve
        def valid_date():
            repeat_date = True
            while repeat_date:
                try:
                    user_booking_date = input(
                        "\nThe reservation can only be booked 5 days in advance.\n\nEnter the booking date ['YYYY-MM-DD']: ")
                    # strptime is used to change the string into datetime object and read it in date format
                    user_booking_date = datetime.strptime(user_booking_date, "%Y-%m-%d").date()
                    repeat_date = False
                  
                except ValueError:
                    print('\nINVALID DATE!', '\nPlease enter the correct format or a valid date')

            current_date = datetime.today().date()
            # timedelta represents duration, it can perform arithmetic with datetime objects
            valid_booking_date = current_date + timedelta(days=5)

            # Check the date whether it valid or not
            # Guests must make their reservations at least 5 days in advance
            while user_booking_date < valid_booking_date or user_booking_date < current_date:
                if user_booking_date < current_date:
                    print('\nINVALID BOOKING DATE')
                  
                else:
                    print('\nThe reservation can only be booked 5 days in advance.')

                repeat_date = True
                while repeat_date:
                    try:
                        user_booking_date = input("\nEnter the booking date ['YYYY-MM-DD']: ")
                        user_booking_date = datetime.strptime(user_booking_date, "%Y-%m-%d").date()
                        repeat_date = False
                      
                    except ValueError:
                        print('\nINVALID DATE!', '\nPlease enter the correct format or a valid date')

            return user_booking_date


        # Function for displaying menu
        def display_menu(menu_list, start, end):
            count = 1

            for food in menu_list[start:end]:
                print(f"[{count}] {food}")
                count += 1


        # Function to get the user input based on their choices according to every category (appetizer, main course, dessert and drinks)
        def get_user_input(prompt, lower_limit, upper_limit):
            while True:
                try:
                    value = int(input(prompt))
                    # Error message will be printed if user enter the number out of range
                    if lower_limit <= value <= upper_limit:
                      
                        return value
                      
                    else:
                        print(f"\nEnter an integer between {lower_limit} and {upper_limit - 1}!")
                      
                except ValueError:
                    print(f"\nEnter only integers between {lower_limit} and {upper_limit - 1}!")


        # Function for display reservation
        def reservation_list():
            os.system('cls')
            # Create dictionaries to store reservations based on date
            reservations_by_date = {}

            file_R.seek(0)
            # Read each line and store the reservations in the dictionaries
            for lines in file_R:
                reservation = lines.strip().split('|')
                reservation_date = reservation[0]

                if reservation_date not in reservations_by_date:
                    reservations_by_date[reservation_date] = []
                reservations_by_date[reservation_date].append(reservation)

            # Sort the data according to the date in ascending order
            ordered_data = sorted(reservations_by_date.items(),
                                  key=lambda dates: datetime.strptime(dates[0], '%Y-%m-%d'))
            # Print reservations by date according to date
            print(f"{'Reservations by Date':^100}")
            print(f"{'-' * 110}")
            print(f"| {'Date':<10} | {'Slot':<6} | {'Name':<30} | {'Email':<30} | {'Phone':<12} | {'Pax'} | ")
            print(f"{'-' * 110}")

            for reservation_date, reservations in ordered_data:
                for reservation in reservations:
                    dates = reservation[0]
                    slots = reservation[1]
                    names = reservation[2]
                    emails = reservation[3]
                    phones = reservation[4]
                    pax = reservation[5]
                    print(f"| {dates} | {slots} | {names:<30} | {emails:<30} | {phones:<12} | {pax:^3} |")
                print(end='')


        # Function for generating menu choices and obtain user input for the food they wish to order
        def generate_menu_choice(menu_list, start, end):
            display_menu(menu_list, start, end)
            choice = get_user_input("\nPlease enter your choice: ", 1, end - start + 1)
          
            return menu_list[start + choice - 1]


        # Function to generate menu by retrieving values from list
        def generate_menu(menu_list):
            appetizer = generate_menu_choice(menu_list, 1, 6)
            main_course = generate_menu_choice(menu_list, 8, 15)
            dessert = generate_menu_choice(menu_list, 17, 23)
            drinks = generate_menu_choice(menu_list, 25, 32)
          
            return appetizer, main_course, dessert, drinks


        # Function for dispaying the menu according to appetizer, main courses, dessert and drinks
        def choose_menu(menu_list):
            repeat_generate = True
            while repeat_generate:
                os.system('cls')  
                print("For appetizers, we offer:\n")
                appetizer = generate_menu_choice(menu_list, 1, 6)
                os.system('cls')

                print("For main courses, we offer:\n")
                main_course = generate_menu_choice(menu_list, 8, 15)
                os.system('cls')

                print("For dessert, we offer:\n")
                dessert = generate_menu_choice(menu_list, 17, 23)
                os.system('cls')

                print("For drinks, we offer:\n")
                drinks = generate_menu_choice(menu_list, 25, 32)
                os.system('cls')

                customer_meal = f"\nAppetizer: {appetizer}\nMain Course: {main_course}\nDessert: {dessert} \nDrinks: {drinks}"
                print(customer_meal)

                if not repeat_operation():
                    break


        # Function to generate random menu by randomly generate choices for them
        def generate_random_menu(menu_list):
            repeat_generate = True
            while repeat_generate:
                os.system('cls')
                # generate menu choices based on different category of food
                appetizer = random.choice(menu_list[1:6])
                main_course = random.choice(menu_list[8:15])
                dessert = random.choice(menu_list[17:23])
                drinks = random.choice(menu_list[25:32])

                print('Here is your suprise menu!!')
                print("\nAppetizer:", appetizer)
                print("Main Course:", main_course)
                print("Dessert:", dessert)
                print("Drinks:", drinks)

                if not repeat_operation():
                    break

        # Function for displaying options for user in Case 5 (Whether to choose menu themselves / Need surprise)
        def generate_meal_recommendation(menu_list):
            repeat_generate_menu = True
            while repeat_generate_menu:
                print("Generate Meal Recommendation\n")
                print("[1] Choose from menu\n\n[2] Need Surprise!!\n\n[3] Go back to Main Menu\n")

                recommendation = input("Enter 1 to 3: ")

                if recommendation == '1':
                    choose_menu(menu_list)

                elif recommendation == '2':
                    generate_random_menu(menu_list)

                elif recommendation == '3':
                    repeat_generate_menu = False

                else:
                    os.system('cls')
                    # Perform exception handling for invalid user input
                    # A valid input should only be either 1, 2 or 3
                    print("Please enter 1 to 3 and nothing else!\n")
                  
        # Function to repeat operation
        def repeat_operation():
            repeat = input("\nWould you like to repeat this reservation operation? [YES/NO]: ").upper()

            # Exception handling if user input is not "YES" or "NO"
            while repeat != "YES" and repeat != "NO":
                repeat = input("\nWould you like to repeat this reservation operation? [YES/NO]: ").upper()
    
            if repeat == "YES":
                return True

            # If input is "NO", it will return back to the main menu
            if repeat == "NO":
                os.system('cls')
                return False

        repeat_menu = True
        while repeat_menu:  # Done Exception Handling for user input in main menu
            while True:
                try:
                    print("""
                                        ( ( (                   ))
                                         ) ) )                 ((
                                         ( ( (           ___o___)
                                       '. ___ .'        |     |====O
                                      '  (> <) '        |_____|
                                    --ooO-(_)-Ooo--------------------
                    """)
                    print(f"{'Welcome to Charming Thyme Trattoria.':^102}")
                    option = int(input("\n[1] Add Reservation(s)\n\n[2] Cancel Reservation(s)\n\n[3] Update/Edit Reservation(s)\n\n[4] Display Reservation(s)\n\n[5] Generate Meal Recommendation(s)\n\n[6] Exit System\n\nEnter the option from 1-6: "))

                    match option:
                        case 1:  # Add reservations
                            repeat = True
                            while repeat:
                                os.system('cls')
                                print("Add Reservation")
                                print("\nPlease provide the information below to add reservation.")

                                # Calling valid_date(), enter_slot(), enter_name(), enter_email(), enter_phone_number() and enter_numpax() to get user input
                                user_booking_date = valid_date()
                                user_booking_date_str = str(user_booking_date) # Assign into string to be able to find in nested_list
                                matched_date = match_date_input(user_booking_date_str) # Calling the match_date_input() to find the matching date

                                slot = enter_slot(user_booking_date_str)
                                name = enter_name()
                                email = enter_email()
                                phone = enter_phone_number()
                                num_pax = enter_numpax()

                                customer = [name, email, phone, num_pax]

                                # Check if the date exists in the nested_list, if not, creat a new list
                                if not matched_date:
                                    matching_date = [user_booking_date_str, [[], [], [], []]]
                                    nested_list.append(matching_date)

                                # if date already exists
                                else:
                                    matching_date = matched_date[0]
                                # 
                                matching_date[1][int(slot) - 1].append(customer)

                                # To display the reservation made by customer
                                print(f"\n{user_booking_date}|Slot {slot}|{name}|{phone}|{email}|{num_pax}")

                                print("\nThe reservation has been added successfully into the system!!")

                                # Ask user if they would like to add another reservation
                                if not repeat_operation():
                                    break
                                  
                        case 2:  # Cancel reservation
                            repeat = True  # Control cancel reservation loop for multiple cancellation
                            while repeat:
                                os.system('cls')
                                print("Cancel Reservation")
                                # Prompt user to enter reserved date, slot, name and phone number to match the reservation data in the text file
                                matched_user_info = match_reservation()

                                # Delete reservation if found
                                delete_reservation(matched_user_info)
                                print("\nReservation deleted successfully!")

                                # Ask user if they would like to delete another reservation
                                if not repeat_operation():
                                    break

                        case 3:  # Update/Edit reservations
                            os.system('cls')
                            # Prompt the user to enter date, name, slot, and phone number to find the matching data in the text file
                            repeat = True # Control cancel reservation loop for multiple update
                            while repeat:
                                try:
                                    choice_error = True
                                    while choice_error: # Error handling for edit_choice
                                        print("Update/Edit Reservation ")
                                        edit_choice = int(input("\nWhat you would like to update:\n\n[1] Reservation Date and Slot \n\n[2] Reservation Information (name, email, phone number & pax) \n\n[3] Go Back to Main Menu\n\nEnter 1, 2 or 3 to select: "))
                                        match edit_choice:
                                            case 1: # Editing reservation date and slot
                                                os.system('cls')
                                                matched_user_info = match_reservation() # Calling the function to find a match

                                                delete_reservation(matched_user_info) # Calling the function to delete the matched one

                                                user_booking_date = valid_date() # Calling the functiont to contol the input error
                                                user_booking_date_str = str(user_booking_date) # Assigning into string to be able to find in nested_list
                                                matched_date = match_date_input(user_booking_date_str) # Calling a function to find a matching date
 
                                                if not matched_date: # Creating a new list if there is no matching date and append it into nested_list
                                                    matching_date = [user_booking_date_str, [[], [], [], []]]
                                                    nested_list.append(matching_date)

                                                else: # if the date is already exists
                                                    matching_date = matched_date[0]

                                                slot = enter_slot(user_booking_date_str) # Calling the function to conto the input error
                                                matched_slot = match_slot_input(int(slot) - 1, matched_date) # Calling the function to find a matching slot
                                                if not matched_slot: # Appending the information if the selected slot that has no reservation
                                                    matching_date[1][int(slot) - 1] = [matched_user_info]

                                                else: # Appending into the existing slot list that contains a few reservation already
                                                    matched_slot.append(matched_user_info)

                                                print("\nReservation moved successfully!")
                                                # Asking whether the user want to update more or not
                                                if not repeat_operation():
                                                    repeat = False
                                                    break

                                            case 2: # Editing name, email, phone number and pax                     
                                                os.system('cls')
                                                matched_user_info = match_reservation() # calling the function to find a match first
                                                print("\nEnter new information below.") 
                                                # after found a match, prompt the user to input name, email, phone number and pax
                                                name = enter_name()
                                                email = enter_email()
                                                phone = enter_phone_number()
                                                num_pax = enter_numpax()

                                                # Update the nested_list with the new inputs
                                                if matched_user_info:  # Iterate in nested list to find reservation
                                                    for entry in nested_list:
                                                        for slot_list in entry[1]:
                                                            if matched_user_info in slot_list:
                                                                matched_user_info[0] = name
                                                                matched_user_info[1] = email
                                                                matched_user_info[2] = phone
                                                                matched_user_info[3] = num_pax
                                                                print("\nReservation updated successfully!")
                                                # Asking whether the use want to update more or not
                                                if not repeat_operation():
                                                    repeat = False
                                                    break
                                                    
                                            case 3: # user choose to go back to main page
                                                choice_error = False
                                                repeat = False

                                            case _: 
                                                os.system('cls')
                                                print("\nERROR! Please enter 1 to 3 and nothing else!\n")
                                                if edit_choice == 1 or edit_choice == 2:
                                                    if 1 > edit_choice > 2:
                                                        choice_error = False
                                                        break
                                                      
                                except ValueError: 
                                    os.system('cls')
                                    print("\nERROR! Please enter 1 to 3 and nothing else!\n")

                        case 4:  # Display reservations
                            repeat_display = True
                            while repeat_display:
                                reservation_list()

                                # Allow user to repeat display reservation
                                if not repeat_operation():
                                    break

                        case 5:  # Generate meal recommendation
                            os.system('cls')
                            menu_file = 'menuItems_22031645.txt'
                            mode = 'r'

                            with open(menu_file, mode) as file_M:  # Opening the menuItems_22031645.txt in read mode
                                menu_list = file_M.readlines()  # Convert every line in text file to a list

                            # Calling generate_meal_recommendation() for choosing options
                            generate_meal_recommendation(menu_list)

                        case 6:  # Exit system
                            os.system('cls')
                            print("""               
                                                 ......               
                                              .:||||||||:.            
                                             /            \           
                                            (   o      o   )          
                                  --@@@@----------:  :----------@@@@--""")
                            print(f"{'Thank you for using our system!!':^104}")

                            # Update reservations to text file
                            file_R.seek(0)
                            file_R.truncate()
                            nested_list_to_text_file(nested_list, file_R)
                            repeat_menu = False
                            break

                        case _:  # Perform exception handling for entering invalid input (values besides 1-6)
                            print("\nPlease enter the integers within 1-6 and nothing else!!")

                            if 1 <= option <= 5:
                                repeat_generate = False
                                break

                            else:
                                os.system('cls')
                                print("\nEnter only 1 to 6 and nothing else!!\n")

                except ValueError:  # Perform exception handling for entering invalid input (non-digit values)
                    os.system('cls')
                    print("\nEnter 1 to 6 and nothing else!!\n")

 # Perform exception handling for opening reservation_22031645.txt file

except FileNotFoundError:
    print("\nThe file does not exist.")

except PermissionError:
    print("\nYou don't have permission to access the file.")

except IOError:
    print("\nAn I/O error occurred while opening the file.")
