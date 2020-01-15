VERSION=`npm view react-native-headless version`
git add .
git pull
git commit -a -m "${VERSION}"
git push
#npm version patch
#npm publish
#./npm_publish.sh