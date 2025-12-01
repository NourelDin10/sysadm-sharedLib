package edu.iti;

def build(imageName, imageName) {
    sh "docker build -t $imageName:imagetag ."
}
def login(username, password) {
    sh"docker login -u $username -p $password"
}
def push(imageName, imageName) {
    sh "docker push $imageName:imagetag"
}
