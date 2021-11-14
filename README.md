# Phone Number

Used to list all available phone numbers.

**URL** : `/phone-numbers/`

**Method** : `GET`

## Success Response

**Code** : `200 OK`

**Content example**

```json
[
  {
    "id": 1,
    "number": "+61412345678",
    "customer": {
      "id": 1
    }
  },
  {
    "id": 2,
    "number": "+61881234567",
    "customer": {
      "id": 1
    }
  },
  {
    "id": 1,
    "number": "+61412222222",
    "customer": {
      "id": 2
    }
  }
]
```

# Phone Numbers by Customer

Used to list all available phone numbers for a customer.

**URL** : `/customers/{id}/phone-numbers/`

**Method** : `GET`

## Success Response

**Code** : `200 OK`

A list of phome numbers are returned. If the customer is valid but does not have any phone numbers, an empty list is returned.

**Content example**

```json
[
  {
    "id": 1,
    "number": "+61412345678",
    "customer": {
      "id": 1
    }
  },
  {
    "id": 2,
    "number": "+61881234567",
    "customer": {
      "id": 1
    }
  }
]
```

## Not Found Response

**Code** : `404 NOT FOUND`

If an id is passed in for a customer that does not exist.