package edu.iti;

def build(imageName, imagetag) {
    sh "docker build -t $imageName:imagetag ."
}
def login(username, password) {
    sh"docker login -u $username -p $password"
}
def push(imageName, imagetag) {
    sh "docker push $imageName:imagetag"
}
