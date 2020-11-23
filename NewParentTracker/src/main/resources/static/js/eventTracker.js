window.addEventListener("load", function () {
  console.log("Script loaded");

  init();
});

function init() {
    document.searchForBabyForm.lookup.addEventListener('click', function(event) {
        event.preventDefault();
        var babyId = document.searchForBabyForm.babyId.value;
        if (!isNaN(babyId) && babyId > 0) {
          getBaby(babyId);
        }
      });
      document.newBabyForm.submit.addEventListener('click', function(evt){
        evt.preventDefault();
        postNewBaby(evt);
      });

      document.updateBabyForm.submit.addEventListener('click', function(evt){
        evt.preventDefault();
        editBaby(evt);
      });

      document.deleteBabyForm.submit.addEventListener('click', function(evt){
        evt.preventDefault();
        deleteBaby(evt);
      });

      

  console.log("in init()");
  }

  function getBaby(babyId) {
    console.log('getBaby(): babyId=' + babyId);
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'api/baby/' + babyId);
    xhr.onreadystatechange = function() {
        if ( xhr.readyState === 4 ) {
            if ( xhr.status === 200 ) {
                let baby = JSON.parse(xhr.responseText);
                console.log(xhr.responseText);
          console.log(baby);
          displayBaby(baby);
            }
            else {
          console.error('Baby not found.');
          displayError('Baby not found.')
            }
        }
    };
    xhr.send();
  }

  function displayError(msg) {
    let div = document.getElementById('babyData');
    div.textContent = msg;
  }

  function displayBaby(baby) {
    var dataDiv = document.getElementById('babyData');
    dataDiv.textContent = '';
    let h1 = document.createElement('h1');
    h1.textContent = baby.name;
    dataDiv.appendChild(h1);
    let ul = document.createElement('ul');

    let li = document.createElement('li');
    li.textContent = baby.age;
    ul.appendChild(li);

    li = document.createElement('li');
    li.textContent = baby.lastFeed;
    ul.appendChild(li);

    li = document.createElement('li');
    li.textContent = baby.timeSlept;
    ul.appendChild(li);
    
    li = document.createElement('li');
    li.textContent = baby.numberOfNaps;
    ul.appendChild(li);
    
    li = document.createElement('li');
    li.textContent = baby.numberOfDiaperChanges;
    ul.appendChild(li);

    dataDiv.appendChild(ul);
    
  }

  function postNewBaby(e) {
    let form = document.newBabyForm;
    let newBaby = {
      name: form.name.value,
      age: form.age.value,
      lastFeed: form.lastFeed.value,
      timeSlept: form.timeSlept.value,
      numberOfNaps: form.numberOfNaps.value,
      numberOfDiaperChanges: form.numberOfDiaperChanges.value
    };
    console.log(newBaby);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'api/baby');
    xhr.onreadystatechange = function(){
      if (xhr.readyState === 4) {
        if (xhr.status === 201 || xhr.status === 200) {
          let savedBaby = JSON.parse(xhr.responseText);
          displayBaby(savedBaby);
        }
        else {
          console.error('Error creating baby, status=' + xhr.status);
          console.error(xhr.responseText);
          displayError('Invalid Baby data.');
        }
      }
    };
    xhr.setRequestHeader('Content-type','application/json')
    xhr.send(JSON.stringify(newBaby));
  }

  function editBaby(babyId){
      let  form = document.updateBabyForm;
      editedBaby = {};

      if(displayBaby.name.value !=='' && displayBaby.age.value !=='' && displayBaby.lastFeed.value !=='' && displayBaby.timeSlept.value !=='' && displayBaby.numberOfNaps.value !=='' && displayBaby.numberOfDiaperChanges.value !==''){
          editedBaby.name = form.displayBaby.name.value;
          editedBaby.age = form.displayBaby.age.value;
          editedBaby.lastFeed = form.displayBaby.lastFeed.value;
          editedBaby.timeSlept = form.displayBaby.timeSlept.value;
          editedBaby.numberOfNaps = form.displayBaby.numberOfNaps.value;
          editedBaby.numberOfDiaperChanges = form.displayBaby.numberOfDiaperChanges.value
      };
      let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'api/baby' + babyId);
    xhr.onreadystatechange = function(){
      if (xhr.readyState === 4) {
        if (xhr.status === 201 || xhr.status === 200) {
          let newEditedBaby = JSON.parse(xhr.responseText);
          displayBaby(newEditedBaby);
        }
        else {
          console.error('Error updating baby, status=' + xhr.status);
          console.error(xhr.responseText);
          displayError('Invalid Baby data.');
        }
      }
    };
    xhr.setRequestHeader('Content-type','application/json')
    xhr.send(JSON.stringify(newEditedBaby));
  }
  
function deleteBaby(babyId){
    let form = document.deleteBabyForm;
    let xhr = new XMLHttpRequest();
    xhr.open('DELETE', 'api/baby/' + babyId);
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4) {
            if (xhr.status === 204 || xhr.status === 200) {
                console.log('ENTRY DELETED');
                form.reset;
                
            }
            else{ displayError('DELETE FAILED');
        }
    }
}
xhr.setRequestHeader("Content-type", "application/json");
xhr.send();

}




//xhr.open('DELETE', 'api/baby/' + babyId);
