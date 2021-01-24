## Creating and setting virtual environment

```
* pip3 install -U pip virtualenv
* virtualenv --system-site-packages -p python3 ./venv
* .\venv\Scripts\activate
```
## 

```
* pip install -r requirements.txt
* python manage.py rename demo djecommerce
* python manage.py migrate
* python manage.py runserver
```

##

```
* pip install django-allauth
```
## All Auth

```
* pip install django-allauth
```

```
    AUTHENTICATION_BACKENDS = (
        'django.contrib.auth.backends.ModelBackend',
        
        'allauth.account.auth_backends.AuthenticationBackend',
    )
```
### Add these to installed app
```
    'django.contrib.sites',
    'allauth',
    'allauth.account',
    'allauth.socialaccount',
```
```
SITE_ID = 1
```

### Add these to urls.py
```
    path('accounts/', include('allauth.urls')),
```

###
```
python manage.py makemigrations
python manage.py migrate
python manage.py createsuperuser
python manage.py runserver
```

### If anything happens with database, delete the database and add these commands to recreate

```
* python manage.py makemigrations core
* python manage.py migrate
* python manage.py createsuperuser
* python manage.py runserver
```
### For images
```
pip install pillow
pip freeze > requirements.txt
```
