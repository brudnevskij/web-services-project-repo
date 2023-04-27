FROM python:3

WORKDIR /app

COPY . /app

RUN pip install --trusted-host pypi.python.org -r pip.txt

# EXPOSE 8880

CMD ["python3", "soap-server.py"]