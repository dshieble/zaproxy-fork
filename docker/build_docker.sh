# Initialize
colima start
sudo ln -sf $HOME/.colima/default/docker.sock /var/run/docker.sock


# cd docker
# docker build --platform=linux/amd64 -t  danshiebler/private:zap_stable -f Dockerfile-local .;


# Build and puah
git add -A .; git commit -m "update"; git push; \
  docker build --platform=linux/arm64 -t  danshiebler/private:zap_stable -f docker/Dockerfile-local .; \
  docker image push  danshiebler/private:zap_stable