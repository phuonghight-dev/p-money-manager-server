# MONEY MANAGER BACKEND SERVICE

### Model

1. Common:
2. Role: id, name, users
3. User: id, full name, username(email), password, avatar, wallets, role
4. Wallet: id, name, transactions
5. Category: id, type, name, image, transactions
6. Transaction: id, name, total, time, location(nullable), withPerson(nullable), image(nullable), category
