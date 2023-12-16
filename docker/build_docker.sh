colima start
sudo ln -sf $HOME/.colima/default/docker.sock /var/run/docker.sock

git add -A .; git commit -m "update"; git push;
# cd docker
# docker build --platform=linux/amd64 -t  danshiebler/private:zap_stable -f Dockerfile-local .;
docker build --platform=linux/arm64 -t  danshiebler/private:zap_stable -f docker/Dockerfile-local .;


docker image push  danshiebler/private:zap_stable