document.addEventListener("DOMContentLoaded", function() {
    // getPosts();
    validateToken();

    // document.getElementById('post-button').addEventListener('click', function() {
    //     const postText = document.getElementById('post-text').value;
    //     if (postText.trim() !== ''  && postText.length <= 140) {

    //         const tempUser = {
    //             username: 'usuario_temporal',
    //             password: 'contraseña_temporal'
    //         };

    //         const postData = {
    //             owner: tempUser,
    //             content: postText
    //         };
    //         fetch('/posts', {
    //             method: 'POST',
    //             headers: {
    //                 'Content-Type': 'application/json'
    //             },
    //             body: JSON.stringify(postData)
    //         })
    //         .then(response => {
    //             if (response.ok) {
    //                 document.getElementById('post-text').value = '';
    //                 getPosts();
    //             } else {
    //                 console.error('Error al enviar el post:', response.statusText);
    //             }
    //         })
    //         .catch(error => console.error('Error al enviar el post:', error));
    //     } else {
    //         console.error('El campo de texto está vacío');
    //     }
    // });
});


// function getPosts() {
//     fetch('/streams')
//         .then(response => response.json())
//         .then(posts => {
//             document.getElementById('post-list').innerHTML = '';
//             posts.reverse().forEach(post => {
//                 addPostToPage(post);
//             });
//         })
//         .catch(error => console.error('Error al obtener los posts:', error));
// }

// function addPostToPage(post) {
//     const postDiv = document.createElement('div');
//     postDiv.className = 'post';
//     const postText = document.createElement('p');
//     postText.textContent = post.content; 
//     postDiv.appendChild(postText);
//     document.getElementById('post-list').appendChild(postDiv);
// }

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
    return fragment.split('=')[1];
}