# Java Project: Booking API
> This API will allow you to take control over the equipments your employees are using or requesting. And for further editions, it may also include a service request system for IT Teams.

The API is accessible on [Not Acessible Yet.](https://github.com/gabeleonn/).

## Table of Contents

-   [Departments](#Departments)
-   [Categories](#Categories)
-   [Employees](#Employees)
-   [Equipments](#Equipments)
-   [Tickets](#Tickets)

## Departments
  
| URI                       |  HTTP  | Body | Description                      |
| :------------------       | :----: | :--: | :-------------------------       |
| /departments              |   GET  |   -  | Get a list of all departments    |
| /departments/:id          |   GET  |   -  | Get details of an department     |
| /departments              |  POST  | JSON | Add a new department             |
| /departments/:id          |  PATCH |   -  | Update a department              |
| /departments/:id          | DELETE |   -  | Delete a department              |

```javascript
{
    "id": integer,
    "name": string,
    "shortName": string
}
```

## Categories
  
| URI                      |  HTTP  | Body | Description                    |
| :------------------      | :----: | :--: | :-------------------------     |
| /categories              |   GET  |   -  | Get a list of all categories   |
| /categories/:id          |   GET  |   -  | Get details of an category     |
| /categories              |  POST  | JSON | Add a new category             |
| /categories/:id          |  PATCH |   -  | Update a category              |
| /categories/:id          | DELETE |   -  | Delete a category              |

```javascript
{
    "id": integer,
    "name": string,
    "shortName": string
}
```

## Employees

| URI                     |  HTTP  | Body | Description                    |
| :------------------     | :----: | :--: | :-------------------------     |
| /employess              |   GET  |   -  | Get a list of all employess    |
| /employess/:id          |   GET  |   -  | Get details of an employee     |
| /employess              |  POST  | JSON | Add a new employee             |
| /employess/:id          |  PATCH |   -  | Update a employee              |
| /employess/:id          | DELETE |   -  | Delete a employee              |

```javascript
{
    "id": integer,
    "code": string,
    "first_name": string,
    "last_name": string,
    "email": string,
    "password": string,
    "department": Department
}
```

## Equipments

| URI                     |  HTTP  | Body | Description                    |
| :------------------     | :----: | :--: | :-------------------------     |
| /equipments              |   GET  |   -  | Get a list of all equipments    |
| /equipments/:id          |   GET  |   -  | Get details of an equipment     |
| /equipments              |  POST  | JSON | Add a new equipment             |
| /equipments/:id          |  PATCH |   -  | Update a equipment              |
| /equipments/:id          | DELETE |   -  | Delete a equipment              |

```javascript
{
    "id": integer,
    "description": string,
    "isActive": boolean,
    "inUse": boolean,
    "category": Category,
    "boughtAt": date
    "lastMaintance": date
}
```

## Tickets

| URI                   |  HTTP  | Body | Description                  |
| :------------------   | :----: | :--: | :-------------------------   |
| /tickets              |   GET  |   -  | Get a list of all tickets    |
| /tickets/:id          |   GET  |   -  | Get details of an ticket     |
| /tickets              |  POST  | JSON | Add a new ticket             |
| /tickets/:id          |  PATCH |   -  | Update a ticket              |
| /tickets/:id          | DELETE |   -  | Delete a ticket              |

```javascript
{
    "id": integer,
    "description": string,
    "isActive": boolean,
    "inUse": boolean,
    "category": Category,
    "boughtAt": date
    "lastMaintance": date
}
```


### Launch History
* 0.0.1 (29/10/2020)
    * Created every model/entity.
    * Created all base files.
