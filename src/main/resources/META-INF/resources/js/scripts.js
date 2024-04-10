document.addEventListener("DOMContentLoaded", function() {
	validateToken();
    getPosts();

    document.getElementById('post-button').addEventListener('click', function() {
        const postText = document.getElementById('post-text').value;
        if (postText.trim() !== ''  && postText.length <= 140) {
			
			const user = {
				username : 'Andres',
				password : 'daPassword'
			}

            const postData = {
                owner: user,
                content: postText
            };
			
            fetch('https://kbbu4x3jxa.execute-api.us-east-1.amazonaws.com/dev/posts', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
					'Authorization' : '' + localStorage.getItem('ACCESS-TOKEN')
                },
                body: JSON.stringify(postData)
            })
            .then(response => {
                if (response.ok) {
                    document.getElementById('post-text').value = '';
                    getPosts();
                } else {
                    console.error('Error al enviar el post:', response.statusText);
                }
            })
            .catch(error => console.error('Error al enviar el post:', error));
        } else {
            console.error('El campo de texto está vacío');
        }
    });
});


function getPosts() {
    fetch('https://kbbu4x3jxa.execute-api.us-east-1.amazonaws.com/dev/streams', {
		method: 'GET',
		headers: {
			'Authorization' : '' + localStorage.getItem('ACCESS-TOKEN')
			}
		})
        .then(response => response.json())
        .then(posts => {
            document.getElementById('post-list').innerHTML = '';
			posts = JSON.parse(posts);
            posts.reverse().forEach(post => {
                addPostToPage(post);
            });
        })
        .catch(error => console.error('Error al obtener los posts:', error));
}

function addPostToPage(post) {
    const postdiv = document.createElement('div');
    postdiv.classname = 'post';
	
	
    const postOwner = document.createElement('p');
    postOwner.textContent = 'Autor : ' + getUserEmail();
    postdiv.appendChild(postOwner);

	const postText = document.createElement('p');
    postText.textContent = 'Message: ' + post.content;
    postdiv.appendChild(postText);
    document.getElementById('post-list').appendChild(postdiv);
}
//
function validateToken(){
    var accessToken = localStorage.getItem('ACCESS-TOKEN');
    if (!accessToken) {
        var accessToken = getAccessTokenFromUrl();
        if (accessToken) {
            localStorage.setItem('ACCESS-TOKEN', accessToken);
        }else{
            window.location.href = 'https://not-twitter.auth.us-east-1.amazoncognito.com/oauth2/authorize?client_id=gp92ns2e5n422ijsdtq0nb9lh&response_type=token&scope=email+openid+phone&redirect_uri=https%3A%2F%2Fbucket-not-twitter.s3.amazonaws.com%2Findex.html';
        }
    }
}


function getAccessTokenFromUrl() {
    var fragment = window.location.hash.substring(1);
    return fragment.split('&')[0].split('=')[1];
}

function getUserEmail(){
	const jwtToken = localStorage.getItem('ACCESS-TOKEN');
	const decodedToken = JSON.parse(atob(jwtToken.split('.')[1]));
	return decodedToken.email;
}