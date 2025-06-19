INSERT INTO banking.users (id, firstname, lastname, gender, email, username, password, created_at)
VALUES (1, 'John', 'Doe', 'Male', 'john.doe@example.com', 'john_doe',
        '$2a$10$7q1RZK3z4Nwn5RyshmN1SOJECeIyPzUQbT6UdtD0/H6hg7JQzO3Ea', '2025-06-01 10:30:00'),
       (2, 'Jane', 'Smith', 'Female', 'jane.smith@example.com', 'jane_smith',
        '$2a$10$y1oZTx2v3e2KPvA4BoFt8u.e6VRkM9y6/4o2P0oLlwq8J69OxxN2W', '2025-06-03 14:15:00'),
       (3, 'Alex', 'Johnson', 'Non-Binary', 'alex.johnson@example.com', 'alex_johnson',
        '$2a$10$f3n2K7x8qM2rWv3FwX7c9OY3Pz7G2v.vz12345y1ZB2n6Q7JvY1Pm', '2025-06-05 08:45:00'),
       (4, 'Emily', 'Davis', 'Female', 'emily.davis@example.com', 'emily_davis',
        '$2a$10$C8qkL5x9pQ2vWz1Lz9c8OM3JwP8uT5nG5kz12345y8ZP9O5JvB1Lm', '2025-06-07 17:20:00'),
       (5, 'Michael', 'Brown', 'Male', 'michael.brown@example.com', 'michael_brown',
        '$2a$10$T3oL4y8NqW1v9Tx6uF8c2OM7GlpZ5vJm8kZ12345yP2n9O7JvB3Lp', '2025-06-10 13:50:00'),
       (161, 'Jamie', 'Smith', 'Female', 'jamie.smith@example.com', 'jamie_smith', 'SafePass!123',
        '2025-06-15 04:52:39.431211'),
       (193, 'Chris', 'Taylor', 'Non-Binary', 'chris.taylor@example.com', 'chris_taylor', 'securePass!789',
        '2025-06-15 05:00:43.466313'),
       (225, 'Gomolemo', 'Ndlovu', 'Male', 'gomolemondlovu@gmail.com', 'gomolemondlovu', '1111junior',
        '2025-06-15 06:44:56.780775'),
       (289, 'Tshina', 'Mamateezy', 'Male', 'tshinamamteezy@gmail.com', 'tshinamamteezy', '12345678',
        '2025-06-16 16:50:43.221102'),
       (321, 'Tebogo', 'Mokasola', 'Male', 'tebzasola@gmail.com', 'tebzasola', '12345678',
        '2025-06-16 18:01:25.602682');


INSERT INTO banking.transactions (user_id, amount, transaction_type, transaction_date, description)
VALUES (225, 600.00, 'Deposit', '2025-06-16 10:00:00', 'Freelance income'),
       (225, 150.75, 'Withdrawal', '2025-06-16 12:00:00', 'Groceries purchase'),
       (225, 200.00, 'Deposit', '2025-06-17 09:00:00', 'Gift money'),
       (225, 50.00, 'Withdrawal', '2025-06-17 10:30:00', 'Transport expense'),
       (225, 750.00, 'Deposit', '2025-06-18 14:45:00', 'Bonus payment'),
       (225, 90.25, 'Withdrawal', '2025-06-18 16:00:00', 'Restaurant dining'),
       (225, 120.00, 'Withdrawal', '2025-06-19 08:30:00', 'Utility bill payment'),


       (289, 500.00, 'Withdrawal', '2025-06-16 20:00:00', 'Emergency expense'),
       (289, 200.00, 'Deposit', '2025-06-17 08:30:00', 'Refund from vendor'),
       (289, 300.00, 'Deposit', '2025-06-17 10:15:00', 'Salary advance'),
       (289, 80.00, 'Withdrawal', '2025-06-17 12:00:00', 'Buying school supplies'),
       (289, 450.00, 'Deposit', '2025-06-18 09:00:00', 'Loan repayment received'),
       (289, 100.00, 'Withdrawal', '2025-06-18 11:30:00', 'Fuel expense'),
       (289, 75.50, 'Withdrawal', '2025-06-18 19:45:00', 'Dinner with friends'),
       (289, 1000.00, 'Deposit', '2025-06-19 15:00:00', 'Freelance project income'),


       (321, 1200.00, 'Deposit', '2025-06-17 08:00:00', 'Business income'),
       (321, 500.00, 'Deposit', '2025-06-17 09:15:00', 'Investment returns'),
       (321, 250.00, 'Withdrawal', '2025-06-17 10:00:00', 'Office supplies purchase'),
       (321, 1450.00, 'Deposit', '2025-06-17 14:00:00', 'Contract payment received'),
       (321, 100.00, 'Withdrawal', '2025-06-17 16:15:00', 'Lunch meeting expense'),
       (321, 2000.00, 'Deposit', '2025-06-18 09:00:00', 'Project milestone payment'),
       (321, 175.00, 'Withdrawal', '2025-06-18 11:45:00', 'Conference registration fee'),
       (321, 800.00, 'Deposit', '2025-06-19 10:30:00', 'Rental income'),
       (321, 95.00, 'Withdrawal', '2025-06-19 13:30:00', 'Subscription fee'),
       (321, 350.00, 'Withdrawal', '2025-06-19 16:45:00', 'New tech gadget purchase');
